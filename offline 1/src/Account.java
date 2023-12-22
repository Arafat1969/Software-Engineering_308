public abstract class Account {
    private String name;
    private String type;
    private double currentBalance;
    private double requestedAmount;
    private double loanAmount;
    private boolean loanRequest;
    private boolean loanApproval;
    private int accountAge;
    private double loanInterest=.10;
    private int serviceCharge=500;

    protected Account(String name, String type, double currentBalance){
        this.name=name;
        this.type=type;
        this.currentBalance=currentBalance;
        this.loanAmount=0;
        this.loanRequest=false;
        this.loanApproval=false;
        this.accountAge=0;
        this.requestedAmount=0;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract double updateBalance();
    abstract void requestLoan(double amount);

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public boolean isLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(double amount) {
        this.requestedAmount= amount;
        this.loanRequest = true;
    }

    public void setLoanApproval(double amount) {
        if(isLoanRequest()) {
            this.loanApproval = true;
            this.loanRequest = false;
            this.requestedAmount=0;
            requestLoan(amount);
        }
        else {
            this.loanApproval = false;
        }
    }

    public void approvedLoan(double amount){
        setLoanAmount(amount);
        this.loanApproval=false;
        double balance=getCurrentBalance();
        balance+=amount;
        setCurrentBalance(balance);
        double fund= Bank.getInternalFund();
        fund-=amount;
        Bank.setInternalFund(fund);
    }
    public boolean isLoanApproval() {
        return loanApproval;
    }

    public int getAccountAge() {
        return accountAge;
    }

    public void incAccountAge() {
        this.accountAge++;
    }


}
