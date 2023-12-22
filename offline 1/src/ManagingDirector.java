public class ManagingDirector extends Employee{
    ManagingDirector(String name) {
        super(name,true,true,true,true);
    }
    @Override
    public void lookupAccount(Account account){
        System.out.println(account.getName()+"’s current balance "+account.getCurrentBalance()+"$");
    }

    @Override
    public void approveLoan(Account account,double amount){    
        account.setLoanApproval(amount);
    }

    @Override
    public void changeInterestRate(String type,Double changedRate){
        System.out.println("You don’t have permission for this operation");
        if(type.equalsIgnoreCase("Student")) {
            StudentAcc.setInterestRate(changedRate);
        }
        else if(type.equalsIgnoreCase("Savings")) {
            SavingsAcc.setInterestRate(changedRate);
        }
        else if(type.equalsIgnoreCase("Fixed")) {
            FixedAcc.setInterestRate(changedRate);
        }
        else {
            System.out.println("Not a valid account type");
        }
    }

    @Override
    public void seeInternalFund(){
        System.out.println("The internal fund of the Bank is "+Bank.getInternalFund()+"$");
    }
}
