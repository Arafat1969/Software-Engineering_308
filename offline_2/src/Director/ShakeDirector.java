package Director;

import Indredients.BaseIngredient;
import Indredients.CustomizedIngredients;
import Makers.Maker;
import Shakes.Shake;
import Shakes.ShakeType;

import java.util.ArrayList;

public class ShakeDirector {
    private double price;
    public void makeChocolateShake(Maker maker, boolean isLactoseFree, boolean candyChoice, boolean cookieChoice){
        maker.setShakeType(ShakeType.Chocolate_Shake);
        price=230;
        if(!isLactoseFree){
            maker.addMilk(BaseIngredient.Milk);
        }else{
            maker.addAlmondMilk(CustomizedIngredients.Almond_milk);
            price+=60;
        }
        maker.addSugar(BaseIngredient.Sugar);
        maker.addSyrup(BaseIngredient.Chocolate_syrup);
        maker.addIceCream(BaseIngredient.Chocolate_ice_cream);
        if(candyChoice){
            maker.addCandy(CustomizedIngredients.Candy);
            price+=50;
        }
        if(cookieChoice){
            maker.addCookies(CustomizedIngredients.Cookies);
            price+=40;
        }
        maker.setPrice(price);
    }

    public void makeCoffeeShake(Maker maker,boolean isLactoseFree,boolean candyChoice,boolean cookieChoice){
        maker.setShakeType(ShakeType.Coffee_Shake);
        price=250;
        if(!isLactoseFree){
            maker.addMilk(BaseIngredient.Milk);
        }else{
            maker.addAlmondMilk(CustomizedIngredients.Almond_milk);
            price+=60;
        }
        maker.addSugar(BaseIngredient.Sugar);
        maker.addCoffee(BaseIngredient.Coffee);
        maker.addJello(BaseIngredient.Jello);
        if(candyChoice){
            maker.addCandy(CustomizedIngredients.Candy);
            price+=50;
        }
        if(cookieChoice){
            maker.addCookies(CustomizedIngredients.Cookies);
            price+=40;
        }
        maker.setPrice(price);
    }

    public void makeStrawBerryShake(Maker maker,boolean isLactoseFree,boolean candyChoice,boolean cookieChoice){
        maker.setShakeType(ShakeType.Strawberry_Shake);
        price=200;
        if(!isLactoseFree){
            maker.addMilk(BaseIngredient.Milk);
        }else{
            maker.addAlmondMilk(CustomizedIngredients.Almond_milk);
            price+=60;
        }
        maker.addSugar(BaseIngredient.Sugar);
        maker.addSyrup(BaseIngredient.Strawberry_syrup);
        maker.addIceCream(BaseIngredient.Strawberry_ice_cream);
        if(candyChoice){
            maker.addCandy(CustomizedIngredients.Candy);
            price+=50;
        }
        if(cookieChoice){
            maker.addCookies(CustomizedIngredients.Cookies);
            price+=40;
        }
        maker.setPrice(price);
    }

    public void makeVanillaShake(Maker maker,boolean isLactoseFree,boolean candyChoice,boolean cookieChoice){
        maker.setShakeType(ShakeType.Vanilla_Shake);
        price=190;
        if(!isLactoseFree){
            maker.addMilk(BaseIngredient.Milk);
        }else{
            maker.addAlmondMilk(CustomizedIngredients.Almond_milk);
            price+=60;
        }
        maker.addSugar(BaseIngredient.Sugar);
        maker.addSyrup(BaseIngredient.Vanilla_flavoring);
        maker.addJello(BaseIngredient.Jello);
        if(candyChoice){
            maker.addCandy(CustomizedIngredients.Candy);
            price+=50;
        }
        if(cookieChoice){
            maker.addCookies(CustomizedIngredients.Cookies);
            price+=40;
        }
        maker.setPrice(price);
    }

    public void makeZeroShake(Maker maker,boolean isLactoseFree,boolean candyChoice,boolean cookieChoice){
        maker.setShakeType(ShakeType.Zero_Shake);
        price=240;
        if(!isLactoseFree){
            maker.addMilk(BaseIngredient.Milk);
        }else{
            maker.addAlmondMilk(CustomizedIngredients.Almond_milk);
            price+=60;
        }
        maker.addSugar(BaseIngredient.Sweetener);
        maker.addSyrup(BaseIngredient.Vanilla_flavoring);
        maker.addJello(BaseIngredient.Sugar_free_jello);
        if(candyChoice){
            maker.addCandy(CustomizedIngredients.Candy);
            price+=50;
        }
        if(cookieChoice){
            maker.addCookies(CustomizedIngredients.Cookies);
            price+=40;
        }
        maker.setPrice(price);
    }


}
