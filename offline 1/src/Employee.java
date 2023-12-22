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
        System.out.println("You don’t have permission for this operation");
    }
    public void approveLoan(Account account,double amount){
        System.out.println("You don’t have permission for this operation");
    }
    public void changeInterestRate(String type,Double changedRate){
        System.out.println("You don’t have permission for this operation");
    }
    public void seeInternalFund(){
        System.out.println("You don’t have permission for this operation");
    }

}
