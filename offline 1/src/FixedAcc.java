public class FixedAcc extends Account{
    public static double interestRate=0.15;
    public boolean isMatured;
    FixedAcc(String name, String type, double currentBalance) {
        super(name, type, currentBalance);
        isMatured=false;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        FixedAcc.interestRate = interestRate;
    }

    public boolean isMatured() {
        return isMatured;
    }

    public void setMatured() {
        isMatured =true;
    }

    @Override
    void deposit(double amount) {
        if(amount<50000){
            System.out.println("Invalid transaction; current balance "+getCurrentBalance()+"$");
            return;
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

    @Override
    void withdraw(double amount) {
        if(!isMatured()){
            System.out.println("Your Deposit is not matured");
        }else{
            if(amount<0){
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
        setMatured();
        return netProfit;
    }

    @Override
    void requestLoan(double amount) {
        if(getLoanAmount()!=0){
            System.out.println("You haven't repaid your previous loan yet. You cannot request for another loan");
            return;
        }
        if(amount>100000){
            System.out.println("You cannot request for a loan of more than 10000$");
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
