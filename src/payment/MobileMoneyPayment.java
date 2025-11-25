package payment;

public class MobileMoneyPayment implements Payment {

    private String phoneNumber;
    private String pinCode;
    private double feePercentage = 0.01;
    private double balance;

    public MobileMoneyPayment(String phoneNumber, String pinCode, double balance) {
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    @Override
    public String pay(double amount) {
        if (amount <= 0) {
            return "Invalid amount.";
        }

        if (phoneNumber == null || phoneNumber.length() < 8) {
            return "Payment failed: invalid phone number.";
        }

        if (pinCode == null || pinCode.length() != 4) {
            return "Payment failed: invalid PIN.";
        }

        double fee = amount * feePercentage;
        double totalToPay = amount + fee;

        if (balance < totalToPay) {
            return "Payment failed: insufficient balance.";
        }

        balance -= totalToPay;

        return "Paid " + totalToPay + " via Mobile Money. Remaining balance: " + balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public double getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(double feePercentage) {
        this.feePercentage = feePercentage;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
        long temp;
        temp = Double.doubleToLongBits(feePercentage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MobileMoneyPayment other = (MobileMoneyPayment) obj;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (pinCode == null) {
            if (other.pinCode != null)
                return false;
        } else if (!pinCode.equals(other.pinCode))
            return false;
        if (Double.doubleToLongBits(feePercentage) != Double.doubleToLongBits(other.feePercentage))
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MobileMoneyPayment [phoneNumber=" + phoneNumber + ", pinCode=" + pinCode + ", feePercentage="
                + feePercentage + ", balance=" + balance + "]";
    }

}
