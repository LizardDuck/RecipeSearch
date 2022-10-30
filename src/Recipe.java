
import java.util.ArrayList;


/**
 *
 * @author Maxis
 */
@SuppressWarnings("ALL")
public class Recipe {


    private final String name;
    private final int time;
    private ArrayList ingredients;


    public Recipe(String name, int time){
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }
    public int getTime(){
        return this.time;
    }


    @Override
    public String toString() {
        return (name + ", cooking time: " + time);
    }
    public void addIngredients(ArrayList<String> add){

        this.ingredients = (ArrayList)add.clone();
    }
    public void outputIngredients(){
        String output = "";

        for (int i = 0; i < ingredients.size(); i++){
            output += ingredients.get(i) + "  ";
        }
        System.out.println(output);

    }

    public boolean containsIngredient(String in){
        for (Object s: ingredients){
            if (s.equals(in)){
                return true;
            }
        }

        return false;
    }

}
