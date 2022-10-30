
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxis
 */
public class RecipeBook {

    private final ArrayList<Recipe> recipes;

    public RecipeBook(){
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe r){
        recipes.add(r);
    }

    public void outputRecipes(){
        for (Recipe recipe : recipes) {
            String toString = recipe.toString();
            System.out.println(toString);
        }
    }
    public void contains(String s){
        for (Recipe r: recipes){
            if (r.getName().contains(s)) {
                System.out.println(r);
            }
        }
    }
    public void acceptableTime(int i){
        for (Recipe r: recipes) if (r.getTime() <= i) System.out.println(r);

    }

    public void printRecipiesWithIngredient(String s){
        for (Recipe r: recipes) if (r.containsIngredient(s)) System.out.println(r);
    }




}
