import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank=Bank.getInstance();
        Scanner scn= new Scanner(System.in);
        while(true){
            String line=scn.nextLine();
            String[] request=line.split(" ");
            if(request[0].equalsIgnoreCase("Create")){
                bank.CreateAccount(request[1],request[2],Double.parseDouble(request[3]));//Create Alice Student 1000
            }
            else if(request[0].equalsIgnoreCase("Deposit")){//Deposit 20000
                bank.Deposit(Double.parseDouble(request[1]));
            }
            else if(request[0].equalsIgnoreCase("Withdraw")){//Withdraw 12,000
                bank.WithDraw(Double.parseDouble(request[1]));
            }
            else if(request[0].equalsIgnoreCase("Query")){//Query
                bank.Query();
            }
            else if(request[0].equalsIgnoreCase("Request")){//Request 500
                bank.RequestLoan(Double.parseDouble(request[1]));
            }
            else if(request[0].equalsIgnoreCase("Open")){//Open S1
                bank.openUser(request[1]);
            }
            else if(request[0].equalsIgnoreCase("Approve")){//Approve Loan
                bank.ApproveLoan();
            }
            else if(request[0].equalsIgnoreCase("Close")){//Close
                bank.closeUser();
            }
            else if(request[0].equalsIgnoreCase("Change")){//Change Student 7.50
                bank.ChangeInterestRate(request[1],Double.parseDouble(request[2])/100);
            }
            else if(request[0].equalsIgnoreCase("Lookup")){//Lookup Alice
                bank.Lookup(request[1]);
            }
            else if(request[0].equalsIgnoreCase("See")){//See
                bank.SeeInternalFound();
            }
            else if(request[0].equalsIgnoreCase("INC")){//INC
                bank.incrementYear();
            }
            else if(request[0].equalsIgnoreCase("Exit")){
                break;
            }else{
                System.out.println("Invalid operation");
            }
        }
    }
}
