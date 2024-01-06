import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem currentDirectory;
        FileSystem root=Root.getInstance();
        currentDirectory=root;
        Scanner scn= new Scanner(System.in);
        while (true){
            String line= scn.nextLine();
            String request[]=line.split(" ");
            if(request[0].equalsIgnoreCase("cd") && !request[1].equalsIgnoreCase("~")){
                currentDirectory=currentDirectory.changeDirectory(request[1])!=null?currentDirectory.changeDirectory(request[1]):root;
            }else if(request[0].equalsIgnoreCase("ls")){
                currentDirectory.getComponent(request[1]).details();
            }else if(request[0].equalsIgnoreCase("list")){
                currentDirectory.listing();
            }else if(request[0].equalsIgnoreCase("delete") && request[1].compareToIgnoreCase("-r")!=0){
                currentDirectory.delete(request[1]);
            }else if(request[0].equalsIgnoreCase("delete") && request[1].compareToIgnoreCase("-r")==0 ){
                currentDirectory.getComponent(request[2]).recursiveDelete();
                currentDirectory.delete(request[2]);
            }else if(request[0].equalsIgnoreCase("cd") && request[1].equalsIgnoreCase("~")){
                currentDirectory=root;
                System.out.println("Changed to Root directory");
            }else if(request[0].equalsIgnoreCase("mkdir")){
                currentDirectory.makeDir(request[1]);
            }else if(request[0].equalsIgnoreCase("touch")){
                int size=0;
                if(Arrays.stream(request).count()>2){
                    size=Integer.parseInt(request[2]);
                }
                currentDirectory.touch(request[1],size);
            }else if(request[0].equalsIgnoreCase("mkdrive")){
                currentDirectory.makeDrive(request[1]);
            }
        }
    }
}
