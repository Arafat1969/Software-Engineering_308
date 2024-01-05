package Makers;

import Indredients.BaseIngredient;
import Indredients.CustomizedIngredients;
import Shakes.ShakeType;

public interface Maker {
    void setPrice(double price);
    void setShakeType(ShakeType type);
    void addMilk(BaseIngredient milk);
    void addSugar(BaseIngredient sugar);
    void addSyrup(BaseIngredient syrup);
    void addCoffee(BaseIngredient coffee);
    void addIceCream(BaseIngredient iceCream);
    void addJello(BaseIngredient jello);
    void addAlmondMilk(CustomizedIngredients milk);
    void addCandy(CustomizedIngredients candy);
    void addCookies(CustomizedIngredients cookie);
}
