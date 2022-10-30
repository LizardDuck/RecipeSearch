import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {


    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ingredients = new ArrayList<>();
        RecipeBook book = new RecipeBook();
        Recipe add;

        System.out.println("File to read: ");
        String file = scanner.nextLine();

        //read file and make classes
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {

            while (fileScanner.hasNextLine()) {
                String out = fileScanner.nextLine();
                list.add(out);
                while (out.equals("")) {
                    add = new Recipe(list.get(0), Integer.parseInt(list.get(1)));
                    for (int i = 2; i < list.size(); i++) {

                        ingredients.add(list.get(i));
                    }

                    add.addIngredients(ingredients);
                    book.addRecipe(add);

                    ingredients.clear();
                    list.clear();
                    break;
                }

            }

            add = new Recipe(list.get(0), Integer.parseInt(list.get(1)));
            for (int i = 2; i < list.size(); i++) {

                ingredients.add(list.get(i));

            }
            add.addIngredients(ingredients);
            book.addRecipe(add);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        OUTER:
        while (true) {
            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            System.out.println("find ingredient - searches recipes by ingredient");
            System.out.println("Enter command: ");
            String userIn = scanner.nextLine();
            switch (userIn) {
                case "stop":
                    break OUTER;
                case "list":
                    System.out.println("Recipes: ");
                    book.outputRecipes();
                    System.out.println();
                    break;
                case "find name":
                    System.out.println("Searched word: ");
                    userIn = scanner.nextLine();
                    book.contains(userIn);
                    break;
                case "find cooking time":
                    System.out.println("Max cooking time");
                    int userInNum = Integer.parseInt(scanner.nextLine());
                    book.acceptableTime(userInNum);
                    System.out.println();
                    break;
                case "find ingredient":
                    System.out.println("Ingredient: ");
                    userIn = scanner.nextLine();
                    book.printRecipiesWithIngredient(userIn);
                    break;
                default:
                    break;
            }
        }


    }

}
