public abstract class Employee {
    private String name;
    private final boolean lookUpRight;
    private final boolean loanApprovalRight;
    private final boolean changeInterestRight;
    private final boolean seeFundRight;

    protected Employee(String name, boolean lookup_right, boolean loan_approval_right, boolean change_interest_right,
                       boolean see_fund_right){
        this.name=name;
        this.lookUpRight= lookup_right;
        this.loanApprovalRight=loan_approval_right;
        this.changeInterestRight=change_interest_right;
        this.seeFundRight=see_fund_right;
    }

    public boolean isLookUpRight() {
        return lookUpRight;
    }

    public boolean isLoanApprovalRight() {
        return loanApprovalRight;
    }

    public boolean isChangeInterestRight() {
        return changeInterestRight;
    }

    public boolean isSeeFundRight() {
        return seeFundRight;
    }

    public String getName() {
        return name;
    }

    public void lookupAccount(Account account){
        if(!isLookUpRight()){
            System.out.println("You don’t have permission for this operation");
            return;
        }
        System.out.println(account.getName()+"’s current balance "+account.getCurrentBalance()+"$");
    }
    public void approveLoan(Account account,double amount){
        if(!isLoanApprovalRight()){
            System.out.println("You don’t have permission for this operation");
            return;
        }
        account.setLoanApproval(amount);
    }
    public void changeInterestRate(String type,Double changedRate){
        if(!isChangeInterestRight()){
            System.out.println("You don’t have permission for this operation");
            return;
        }
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
    public void seeInternalFund(){
        if(!isSeeFundRight()){
            System.out.println("You don’t have permission for this operation");
            return;
        }
        System.out.println("The internal fund of the Bank is "+Bank.getInternalFund()+"$");
    }

}
