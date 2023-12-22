import java.util.ArrayList;

public class Bank {
    private static double InternalFund=1000000;
    private static int year=0;
    private ManagingDirector MD;
    private ArrayList<Officer> O;
    private ArrayList<Cashier> C;
    private ArrayList<Account> accounts;
    private Account activeAccount;
    private Employee activeEmployee;
    private static Bank bankInstance=null;


    private Bank(){
        accounts=new ArrayList<>();
        MD= new ManagingDirector("MD");
        O=new ArrayList<>(2);
        for (int i=0;i<2;i++){
            O.add(i, new Officer("O"+(i+1)));
        }
        C=new ArrayList<>(5);
        for(int i=0;i<5;i++){
            C.add(i,new Cashier("C"+(i+1)));
        }
        activeAccount=null;
        activeEmployee=null;
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");
    }

    //Used to create a single object of Bank class
    public static synchronized Bank getInstance()
    {
        if (bankInstance == null)
            bankInstance = new Bank();

        return bankInstance;
    }

    //Some setters and getters
    public static double getInternalFund() {
        return InternalFund;
    }

    public static void setInternalFund(double internalFund) {
        InternalFund = internalFund;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public Employee getActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(Employee activeEmployee) {
        this.activeEmployee = activeEmployee;
    }

    //Used to mark or identify the active user or employee
    public void openUser(String name){
        if( getActiveAccount()!=null || getActiveEmployee()!=null){
            closeUser();
        }
        boolean flag=false;
        if(name.equalsIgnoreCase("MD")){
            setActiveEmployee(MD);
        }
        if(name.equalsIgnoreCase("O1")){
            setActiveEmployee(O.get(0));
        }
        if(name.equalsIgnoreCase("O2")){
            setActiveEmployee(O.get(0));
        }
        if(name.equalsIgnoreCase("C1")){
            setActiveEmployee(C.get(0));
        }
        if(name.equalsIgnoreCase("C2")){
            setActiveEmployee(C.get(1));
        }
        if(name.equalsIgnoreCase("C3")){
            setActiveEmployee(C.get(2));
        }
        if(name.equalsIgnoreCase("C4")){
            setActiveEmployee(C.get(3));
        }
        if(name.equalsIgnoreCase("C5")){
            setActiveEmployee(C.get(4));
        }else{
            for(Account acc: accounts){
                if(name.equalsIgnoreCase(acc.getName())){
                    setActiveAccount(acc);
                    System.out.println("Welcome back, "+getActiveAccount().getName());
                    return;
                }
            }
        }
        for(Account acc: accounts){
            if(acc.isLoanRequest()){
                flag=true;
            }
        }
        System.out.print(activeEmployee.getName()+" active");
        if(activeEmployee.isLoanApprovalRight() && flag){
            System.out.print(", there are loan approvals pending");
            System.out.println();
        }

    }

    //To deactivate the account that has logged out
    public void closeUser() {
        if(getActiveEmployee()!=null){
            System.out.println("Operations for "+getActiveEmployee().getName()+" closed");
        }
        if(getActiveAccount()!=null){
            System.out.println("Transaction Closed for "+getActiveAccount().getName());
        }
        setActiveAccount(null);
        setActiveEmployee(null);
    }

    //To increment year and calculate the change in accounts and bank internal fund
    public void incrementYear(){
        for(Account acc : accounts){
            double fund=Bank.getInternalFund();
            fund -= acc.updateBalance();
            Bank.setInternalFund(fund);
        }
        System.out.println("1 year passed");
    }

    //To prevent accounts with same name
    private boolean checkName(String name) {
        for (Account acc:accounts) {
            if(name.equalsIgnoreCase(acc.getName())){
                return true;
            }
        }
        return false;
    }

    //**Code for User Account Operations start from here**

    //To create a new account
    public void CreateAccount(String name,String type,double amount){
        Account acc;
        if (checkName(name)) {
            System.out.println("Name Already Taken.Please enter another name");
            return;
        }
        if(amount<0){
            System.out.println("Please deposit a valid amount");
            return;
        }
        if(type.equalsIgnoreCase("Fixed") && amount<100000){
            System.out.println("Insufficient amount to deposit.Please deposit at least 100000$");
            return;
        }
        if(type.equalsIgnoreCase("Fixed")){
            acc=new FixedAcc(name, type, amount);
            accounts.add(acc);
            setActiveAccount(acc);
            System.out.println(acc.getType()+" account for "+acc.getName()+" Created; initial balance "+acc.getCurrentBalance());
        } else if (type.equalsIgnoreCase("Student")) {
            acc=new StudentAcc(name,type,amount);
            accounts.add(acc);
            setActiveAccount(acc);
            System.out.println(acc.getType()+" account for "+acc.getName()+" Created; initial balance "+acc.getCurrentBalance());
        } else if (type.equalsIgnoreCase("Savings")) {
            acc=new SavingsAcc(name,type,amount);
            accounts.add(acc);
            setActiveAccount(acc);
            System.out.println(acc.getType()+" account for "+acc.getName()+" Created; initial balance "+acc.getCurrentBalance());
        }else {
            System.out.println("Invalid type of account. Valid Account types are: Savings, Student & Fixed");
        }
    }

    //To deposit money in the account
    public void Deposit(double amount){
        if(getActiveAccount()==null){
            System.out.println("Please deposite from a valid account");
            return;
        }
        double previousBalance=activeAccount.getCurrentBalance();
        activeAccount.deposit(amount);
        if(previousBalance!=activeAccount.getCurrentBalance()){
            System.out.println(amount+" deposited; current balance "+ activeAccount.getCurrentBalance());
        }
    }

    //To withdraw money from user's own account
    public void WithDraw(double amount){
        if(getActiveAccount()==null){
            System.out.println("Please withdraw from a valid account");
            return;
        }
        double previousBalance=activeAccount.getCurrentBalance();
        activeAccount.withdraw(amount);
        if(previousBalance!=activeAccount.getCurrentBalance()){
            System.out.println(amount+" deposited; current balance "+ activeAccount.getCurrentBalance());
        }

    }

    //To request for a loan
    public void RequestLoan(double amount){
        if(getActiveAccount()==null){
            System.out.println("Please request from a valid account");
            return;
        }
        if(amount<0){
            System.out.println("Request For a valid amount");
            return;
        }
        activeAccount.requestLoan(amount);
    }

    // To check balance of your account
    public void Query(){
        if(getActiveAccount()==null){
            System.out.println("Please request from a valid account");
            return;
        }
        System.out.print("Current balance "+activeAccount.getCurrentBalance()+"$");
        if(activeAccount.getLoanAmount()!=0){
            System.out.print(", loan 500$\n");
        }
    }

    //**Code for Employee Operations start from here**

    //To check the balance of a account
    public void Lookup(String name){
        if(getActiveEmployee()==null){
            System.out.println("Please lookup from a valid employee account");
            return;
        }
        for(Account acc : accounts){
            if(name.equalsIgnoreCase(acc.getName())){
                activeEmployee.lookupAccount(acc);
                return;
            }
        }
        System.out.println("Account not found");
    }

    //To approve the loans waiting for approval
    public void ApproveLoan(){
        if(getActiveEmployee()==null){
            System.out.println("Please approve from a valid employee account");
            return;
        }
        boolean flag=false;
        for( Account acc : accounts){
            if(acc.isLoanRequest()){
                activeEmployee.approveLoan(acc,acc.getRequestedAmount());
                flag=true;
                if(activeEmployee.isLoanApprovalRight()){
                    System.out.println("Loan for " + acc.getName() + " approved");
                }
            }
        }
        if(!flag){
            System.out.println("No loans to approve.");
        }
    }

    //For changing the Annual Interest Rate of a particular type of account
    public void ChangeInterestRate(String type,double changedRate){
        if(getActiveEmployee()==null){
            System.out.println("Please change interest from a valid employee account");
            return;
        }
        activeEmployee.changeInterestRate(type,changedRate);
    }

    //To check the internal fund of the Bank
    public void SeeInternalFound(){
        if(getActiveEmployee()==null){
            System.out.println("Please change interest from a valid employee account");
            return;
        }
        activeEmployee.seeInternalFund();
    }

}
