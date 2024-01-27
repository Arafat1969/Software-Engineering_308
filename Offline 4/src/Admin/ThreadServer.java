package Admin;

import Admin.Admin;
import Client.User;
import util.SocketWrapper;

import java.io.IOException;

public class ThreadServer implements Runnable {

    private Thread thr;
    Admin admin;
    private SocketWrapper socketWrapper;
    public User currentUser;

    public ThreadServer(Admin admin, SocketWrapper socketWrapper) {
        this.admin=admin;
        this.socketWrapper=socketWrapper;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            String name =(String) socketWrapper.read();
            if(Server.userMap.containsKey(name)){
                currentUser= Server.userMap.get(name);
                currentUser.isActive=true;
                //socketWrapper = Admin.Server.clientMap.get(name)
                Server.clientMap.put(name,socketWrapper);
                socketWrapper.write("Welcome Back");
            }else{
                Server.clientMap.put(name,socketWrapper);
                User user= new User(name);
                currentUser=user;
                Server.userMap.put(name,user);
                socketWrapper.write("Welcome To Stock Exchange");
            }
            for(String str : currentUser.notifications){
                socketWrapper.write(str);
            }
            while (true) {
                String name1 =(String) socketWrapper.read();
                System.out.println(currentUser.getName()+" : "+name1);
                String[] s = name1.split(" ");
                if(s[0].equalsIgnoreCase("S")){
                    for(Stock stock : admin.stocks){
                        if(stock.getName().equalsIgnoreCase(s[1])){
                            boolean flag = stock.subscribe(currentUser);
                            if(flag){
                                socketWrapper.write("Subscribed to "+stock.getName());
                            }else{
                                socketWrapper.write("Already subscribed to "+stock.getName());
                            }
                        }
                    }

                } else if (s[0].equalsIgnoreCase("U")) {
                    for(Stock stock : admin.stocks){
                        if(stock.getName().equalsIgnoreCase(s[1])){
                            System.out.println(currentUser.getName());
                            boolean flag = stock.unSubscribe(currentUser);
                            if(flag){
                                socketWrapper.write("unsubscribed from "+stock.getName());
                            }else{
                                socketWrapper.write("Already unsubscribed from "+stock.getName());
                            }
                        }
                    }
                }else if(s[0].equalsIgnoreCase("V")){
                    String str="";
                    for(Stock stock : admin.stocks){
                        if(stock.View(currentUser.getName())){
                            socketWrapper.write(stock.getName());
                        }
                    }
                }else {
                    socketWrapper.write("Wrong Command");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try {
                currentUser.isActive=false;
                socketWrapper.closeConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



