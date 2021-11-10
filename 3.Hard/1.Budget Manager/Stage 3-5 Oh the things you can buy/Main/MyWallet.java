package budget;

public class MyWallet {
    double myIncome = 0;

    protected double showBalance() {
        return myIncome;
    }

    protected void setMyIncome(double myIncome) {
        this.myIncome += myIncome;
    }

    protected void AddPurchase(double myIncome) {
        this.myIncome -= myIncome;
    }
}
