package Makers;

import Indredients.BaseIngredient;
import Indredients.CustomizedIngredients;
import Makers.Maker;
import Shakes.ShakeType;
import Shakes.Shake;

import java.util.ArrayList;

public class ShakeMaker implements Maker {
    private ShakeType type;
    private ArrayList<BaseIngredient> baseIngredient= new ArrayList<>();
    private ArrayList<CustomizedIngredients> customizedIngredients= new ArrayList<>();
    private double price;

    @Override
    public void setPrice(double price){
        this.price=price;
    }

    @Override
    public void setShakeType(ShakeType type) {
        this.type = type;
    }

    @Override
    public void addMilk(BaseIngredient milk) {
        baseIngredient.add(milk);
    }

    @Override
    public void addSugar(BaseIngredient sugar) {
        baseIngredient.add(sugar);
    }

    @Override
    public void addSyrup(BaseIngredient syrup) {
        baseIngredient.add(syrup);
    }

    @Override
    public void addCoffee(BaseIngredient coffee) {
        baseIngredient.add(coffee);
    }

    @Override
    public void addIceCream(BaseIngredient iceCream) {
        baseIngredient.add(iceCream);
    }

    @Override
    public void addJello(BaseIngredient jello) {
        baseIngredient.add(jello);
    }

    @Override
    public void addAlmondMilk(CustomizedIngredients milk) {
        customizedIngredients.add(milk);
    }

    @Override
    public void addCandy(CustomizedIngredients candy) {
        customizedIngredients.add(candy);
    }

    @Override
    public void addCookies(CustomizedIngredients cookie) {
        customizedIngredients.add(cookie);
    }

    public Shake getShake() {
        Shake shake= new Shake(type,baseIngredient,customizedIngredients,price);
        baseIngredient.clear();
        customizedIngredients.clear();
        return shake;
    }
}
