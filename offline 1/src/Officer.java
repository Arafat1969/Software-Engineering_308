public class Officer extends Employee{
    Officer(String name) {
        super(name,true,true,false,false);
    }
    @Override
    public void lookupAccount(Account account){
        System.out.println(account.getName()+"’s current balance "+account.getCurrentBalance()+"$");
    }
    @Override
    public void approveLoan(Account account,double amount){   
        account.setLoanApproval(amount);
    }
}
