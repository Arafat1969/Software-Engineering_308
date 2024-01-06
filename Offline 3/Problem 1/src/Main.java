import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        while (true){
            String line=scn.nextLine();
            String[] request=line.split(" ");
            String str=request[1].substring(0,4);
            if(str.equalsIgnoreCase("crew")){
                Crewmate basicCrewmate = new BasicCrewmate();
                while (true){
                    String line2=scn.nextLine();
                    if(line2.equalsIgnoreCase("repair")){
                        basicCrewmate.repair();
                    }else if(line2.equalsIgnoreCase("work")){
                        basicCrewmate.work();
                    }else if(line2.equalsIgnoreCase("logout")){
                        basicCrewmate.logout();
                        break;
                    }else{
                        System.out.println("Wrong command");
                    }
                }
            }
            String str2=request[1].substring(0,3);
            if(str2.equalsIgnoreCase("imp")){
                Crewmate imposter=new ImposterDecorator(new BasicCrewmate());
                while (true){
                    String line2=scn.nextLine();
                    if(line2.equalsIgnoreCase("repair")){
                        imposter.repair();
                    }else if(line2.equalsIgnoreCase("work")){
                        imposter.work();
                    }else if(line2.equalsIgnoreCase("logout")){
                        imposter.logout();
                        break;
                    }else{
                        System.out.println("Wrong command");
                    }
                }
            }
        }

    }
}