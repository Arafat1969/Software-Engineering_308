import Director.ShakeDirector;
import Makers.ShakeMaker;
import Shakes.Shake;
import Director.ShakeDirector;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList<Shake> shakes=new ArrayList<>();
        boolean addedAlmondMilk=false;
        boolean addedCandy=false;
        boolean addedCookie=false;
        boolean firstime;
        Scanner scn= new Scanner(System.in);
        ShakeDirector director = new ShakeDirector();
        ShakeMaker maker= new ShakeMaker();
        while(true){
            System.out.println("Please Type 'o' to open order menu :");
            firstime=true;
            String cmd=scn.nextLine();
            if(cmd.equalsIgnoreCase("o")){
                System.out.println("Welcome to the order menu");
                while (true){
                    System.out.println("Choose the shake you want to order : ");
                    System.out.println("1.Type 'ch' for Chocolate Shake");
                    System.out.println("2.Type 'cf' for Coffee Shake");
                    System.out.println("3.Type 's' for Strawberry Shake");
                    System.out.println("4.Type 'v' for Vanilla Shake");
                    System.out.println("5.Type 'z' for Zero Shake");
                    String cmd1=scn.nextLine();
                    if(cmd1.equalsIgnoreCase("o")){
                        System.out.println("You cannot open another order menu without completing the current one.");
                        System.out.println("Please continue with your order");
                        cmd1=scn.nextLine();
                    }
                    if(!cmd1.equalsIgnoreCase("e")){
                        System.out.println("Do your shake to have almond milk instead of regular milk ? Type y or n : ");
                        String cmd2=scn.nextLine();
                        if(cmd2.equalsIgnoreCase("o")){
                            System.out.println("You cannot open another order menu without completing the current one.");
                            System.out.println("Please continue with your order");
                            cmd2=scn.nextLine();
                        }
                        addedAlmondMilk= cmd2.equalsIgnoreCase("y");
                        System.out.println("Do you want to have candy added on top? Type y or n :");
                        String cmd3=scn.nextLine();
                        if(cmd3.equalsIgnoreCase("o")){
                            System.out.println("You cannot open another order menu without completing the current one.");
                            System.out.println("Please continue with your order");
                            cmd3=scn.nextLine();
                        }
                        addedCandy= cmd3.equalsIgnoreCase("y");
                        System.out.println("Do you want to have cookies added on top? Type y or n : ");
                        String cmd4=scn.nextLine();
                        if(cmd4.equalsIgnoreCase("o")){
                            System.out.println("You cannot open another order menu without completing the current one.");
                            System.out.println("Please continue with your order");
                            cmd4=scn.nextLine();
                        }
                        addedCookie= cmd4.equalsIgnoreCase("y");
                    }
                    if(cmd1.equalsIgnoreCase("ch")){
                        director.makeChocolateShake(maker,addedAlmondMilk,addedCandy,addedCookie);
                        Shake shake=maker.getShake();
                        shakes.add(shake);
                        firstime=false;
                    }
                    else if(cmd1.equalsIgnoreCase("cf")){
                        director.makeCoffeeShake(maker,addedAlmondMilk,addedCandy,addedCookie);
                        Shake shake=maker.getShake();
                        shakes.add(shake);
                        firstime=false;
                    }
                    else if(cmd1.equalsIgnoreCase("s")){
                        director.makeStrawBerryShake(maker,addedAlmondMilk,addedCandy,addedCookie);
                        Shake shake=maker.getShake();
                        shakes.add(shake);
                        firstime=false;
                    }
                    else if(cmd1.equalsIgnoreCase("v")){
                        director.makeVanillaShake(maker,addedAlmondMilk,addedCandy,addedCookie);
                        Shake shake=maker.getShake();
                        shakes.add(shake);
                        firstime=false;
                    }
                    else if(cmd1.equalsIgnoreCase("z")){
                        director.makeZeroShake(maker,addedAlmondMilk,addedCandy,addedCookie);
                        Shake shake=maker.getShake();
                        shakes.add(shake);
                        firstime=false;
                    }
                    else if(cmd1.equalsIgnoreCase("e")){
                        if(firstime){
                            System.out.println("You cannot exit order menu without placing a order");
                            firstime=false;
                        }else{
                            int i=1;
                            double totalPrice=0;
                            for (Shake s: shakes){
                                System.out.println();
                                System.out.println("Order Id #SB"+i);
                                i++;
                                totalPrice+=s.getPrice();
                                s.print();
                                System.out.println();
                            }
                            shakes.clear();
                            System.out.println("Total price of the order : Tk."+totalPrice);
                            System.out.println("Order menu closed");
                            break;
                        }
                    }else {
                        System.out.println("You have entered a incorrect request...");
                        System.out.println();
                        System.out.println("Please try again...");
                    }
                }
            }
            else if(cmd.equalsIgnoreCase("c")){
                break;
            }else{
                System.out.println("You have entered a incorrect request...");
                System.out.println("Please try again...");
            }
        }
    }
}
