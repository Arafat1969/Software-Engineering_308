public class Cashier extends Employee {
    Cashier (String name) {
        super(name,true,false,false,false);
    }
    @Override
    public void lookupAccount(Account account){
        System.out.println(account.getName()+"’s current balance "+account.getCurrentBalance()+"$");
    }
}
