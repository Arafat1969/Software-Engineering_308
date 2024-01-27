package Admin;

import Admin.Admin;

import java.util.Scanner;

public class ThreadAdmin implements Runnable {
    private Thread thr;
    Admin admin;
    //private util.SocketWrapper socketWrapper;

    public ThreadAdmin(Admin admin){
        this.admin=admin;
        //this.socketWrapper=socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        try{
            Scanner input = new Scanner(System.in);
            while (true){
                String[] str= input.nextLine().split(" ");
                if(str[0].equalsIgnoreCase("I")){
                    String stockName=str[1];
                    double incAmount=Double.parseDouble(str[2]);
                    admin.increasePrice(stockName,incAmount);
                }else if(str[0].equalsIgnoreCase("D")){
                    String stockName=str[1];
                    double decAmount=Double.parseDouble(str[2]);
                    admin.decreasePrice(stockName,decAmount);
                }else if(str[0].equalsIgnoreCase("C")){
                    String stockName=str[1];
                    int changedCount=Integer.parseInt(str[2]);
                    admin.changeCount(stockName,changedCount);
                }else{
                    System.out.println("Wrong Command");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
