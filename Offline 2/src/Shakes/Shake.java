package Shakes;

import Indredients.BaseIngredient;
import Indredients.CustomizedIngredients;

import java.util.ArrayList;

public class Shake {
    private final ShakeType type;
    private double price;
    private final ArrayList<BaseIngredient> baseIngredients;
    private final ArrayList<CustomizedIngredients> customizedIngredients;
    public Shake(ShakeType type, ArrayList<BaseIngredient> baseIngredients1, ArrayList<CustomizedIngredients> customizedIngredients1, double price) {
        this.type=type;
        this.baseIngredients=new ArrayList<>();
        for(int i=0;i<baseIngredients1.size();i++){
            baseIngredients.add(baseIngredients1.get(i));
        }
        this.customizedIngredients=new ArrayList<>();
        for (int i=0;i<customizedIngredients1.size();i++){
            customizedIngredients.add(customizedIngredients1.get(i));
        }
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void print(){
        System.out.println(type);
        System.out.print("Base Ingredient : ");
        for (int i=0;i<baseIngredients.size();i++) {
            System.out.print(baseIngredients.get(i));
            System.out.print((i==baseIngredients.size()-1)?" ":", ");
        }
        System.out.println();
        System.out.print("Customized Ingredient : ");
        for (int i=0;i<customizedIngredients.size();i++) {
            System.out.print(customizedIngredients.get(i));
            System.out.print((i==customizedIngredients.size()-1)?" ":", ");
        }
        System.out.println();
        for (int i=0;i<customizedIngredients.size();i++) {
            if( customizedIngredients.get(i) == CustomizedIngredients.Almond_milk){
                System.out.println("Tk.60 increased for substituting almond milk for regular milk ");
            }
            if( customizedIngredients.get(i)== CustomizedIngredients.Candy){
                System.out.println("Tk.50 increased for adding Candy ");
            }
            if( customizedIngredients.get(i)== CustomizedIngredients.Cookies){
                System.out.println("Tk.40 increased for adding cookie");
            }
        }
        System.out.println("The price of "+type+" is : "+price);

    }
}
