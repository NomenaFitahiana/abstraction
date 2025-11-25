package payment;

public class CashPayment implements Payment {

    public CashPayment() {

    }

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " in cash.";
    }
}
