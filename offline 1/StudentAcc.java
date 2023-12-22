public class StudentAcc extends Account{
    public static double interestRate=.05;
    StudentAcc(String name, String type, double currentBalance) {
        super(name, type, currentBalance);
    }

    @Override
    void deposit(double amount) {
        if(amount<0){
            System.out.println("Invalid transaction; current balance "+getCurrentBalance()+"$");
        }
        if(getLoanAmount()!=0 && amount>getLoanAmount()){
            amount-=getLoanAmount();
            double fund=Bank.getInternalFund();
            fund+=getLoanAmount();
            Bank.setInternalFund(fund);
            setLoanAmount(0);
            System.out.println("Loan has been cleared");
        }
        double balance=getCurrentBalance();
        balance+=amount;
        setCurrentBalance(balance);
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        StudentAcc.interestRate = interestRate;
    }

    @Override
    void withdraw(double amount) {
        if(amount<0){
            System.out.println("Invalid transaction; current balance "+getCurrentBalance()+"$");
        }
        else if(amount>10000){
            System.out.println("Invalid transaction; current balance "+getCurrentBalance()+"$");
        }
        else if((getCurrentBalance()-amount)<0){
            System.out.println("Invalid transaction; current balance "+getCurrentBalance()+"$");
        }else{
            double balance=getCurrentBalance();
            balance-=amount;
            setCurrentBalance(balance);
        }
    }

    @Override
    double updateBalance() {
        double balance=getCurrentBalance();
        double netProfit=balance*getInterestRate()-getLoanAmount()*getLoanInterest()-getServiceCharge();
        balance+=netProfit;
        if(balance<0){
            setCurrentBalance(0);
            double loan=getLoanAmount();
            loan+=(-balance);
            setLoanAmount(loan);
        }
        else{
            setCurrentBalance(balance);
        }
        incAccountAge();
        return netProfit;
    }

    @Override
    void requestLoan(double amount) {
        if(getLoanAmount()!=0){
            System.out.println("You haven't repaid your previous loan yet. You cannot request for another loan");
            return;
        }
        if(amount>1000){
            System.out.println("You cannot request for a loan of more than 1000$");
            return;
        }
        if(isLoanApproval()) {
            approvedLoan(amount);
            setLoanApproval(0);
        }
        else {
            setLoanRequest(amount);
            System.out.println("Loan request successful, sent for approval.");
        }

    }
}
