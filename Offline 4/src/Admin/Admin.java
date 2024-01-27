package Admin;

import java.io.IOException;
import java.util.ArrayList;

public class Admin  {
    public ArrayList<Stock> stocks;
    public Admin(){
        stocks = new ArrayList<>();
    }

    public void increasePrice(String name,double incPrice) throws IOException{
        for(Stock e : stocks){
            if(e.getName().equalsIgnoreCase(name)){
                e.increasePrice(incPrice);
            }
        }
    }
    public void decreasePrice(String name,double decPrice) throws IOException {
        for(Stock e : stocks){
            if(e.getName().equalsIgnoreCase(name)){
                e.decreasePrice(decPrice);
            }
        }
    }
    public void changeCount(String name,int count) throws IOException{
        for(Stock e : stocks){
            if(e.getName().equalsIgnoreCase(name)){
                e.changeCount(count);
            }
        }
    }

    public void addToStock(Stock stock){
        stocks.add(stock);
    }
}
