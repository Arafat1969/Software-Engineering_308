package Admin;

import util.SocketWrapper;
import Client.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {
    private ServerSocket serverSocket;
    private Admin admin;
    public static HashMap<String, SocketWrapper> clientMap;
    public static HashMap<String, User> userMap;
    final String INPUT_FILE_NAME = "input.txt";
    Server() throws Exception {
        clientMap = new HashMap<>();
        userMap = new HashMap<>();
        admin= new Admin();
        System.out.println("Admin.Server starts:");
        adding();
        try {
            serverSocket = new ServerSocket(33333);
            new ThreadAdmin(admin);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Admin.Server starts:" + e);
        }

    }


    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        new ThreadServer(admin,socketWrapper);
    }

    public void adding ()throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] out = line.split(" ");
            Stock stock= new Stock(out[0],Integer.parseInt(out[1]),Double.parseDouble(out[2]));
            //System.out.println(stock.getName());
            admin.addToStock(stock);
        }
        br.close();
    }

    public static void main(String args[]) throws Exception {
        new Server();
    }
}
