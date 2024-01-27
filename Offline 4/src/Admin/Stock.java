package Admin;

import Admin.Server;
import Client.User;
import util.SocketWrapper;

import java.io.IOException;
import java.util.ArrayList;

public class Stock {
    private String name;
    private int count;
    private double price;
    private ArrayList<User> subscribers;
    public Stock(String name, int count,double price){
        this.name=name;
        this.count=count;
        this.price=price;
        subscribers= new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void increasePrice(double incAmount) throws IOException{
        price+=incAmount;
        //System.out.println("Before write");
        for(User subscriber : subscribers){
            if(subscriber.isActive){
                //System.out.println("Is active");
                SocketWrapper socketWrapper= Server.clientMap.get(subscriber.getName());
                //System.out.println("socket");
                socketWrapper.write("Price increased for the "+getName()+" by "+incAmount);
                //System.out.println("after write");
            }else {
                subscriber.update("Price increased for the "+getName()+" by "+incAmount);
            }
        }
    }

    public void decreasePrice(double decAmount) throws IOException {
        price-=decAmount;
        for(User subscriber : subscribers){
            if(subscriber.isActive){
                SocketWrapper socketWrapper=Server.clientMap.get(subscriber.getName());
                socketWrapper.write("Price decreased for the "+getName()+" by "+decAmount);
            }else {
                subscriber.update("Price decreased for the "+getName()+" by "+decAmount);
            }
        }
    }

    public void changeCount(int cngCount) throws IOException{
        count=cngCount;
        for(User subscriber : subscribers){
            if(subscriber.isActive){
                SocketWrapper socketWrapper=Server.clientMap.get(subscriber.getName());
                socketWrapper.write("Count changed for the "+getName()+" to "+cngCount);
            }else {
                subscriber.update("Count changed for the "+getName()+" to "+cngCount);
            }
        }
    }
    public boolean subscribe(User user){
        for(User subscriber : subscribers){
            if(subscriber.getName().equalsIgnoreCase(user.getName())){
                return false;
            }
        }
        subscribers.add(user);
        return true;
    }

    public boolean unSubscribe(User user){
        for(User subscriber : subscribers){
            if(subscriber.getName().equalsIgnoreCase(user.getName())){
                subscribers.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean View(String str){
        for(User user : subscribers ){
            if(user.getName()!=null){
                if(user.getName().equalsIgnoreCase(str)){
                    return true;
                }
            }
        }
        return false;
    }
}
