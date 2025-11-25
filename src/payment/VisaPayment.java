package payment;

public class VisaPayment implements Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String securityCode;
    private double feePercentage = 0.02;
    private double balance;

    public VisaPayment(String cardNumber, String cardHolderName, String expirationDate, String securityCode,
            double balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.balance = balance;
    }

    @Override
    public String pay(double amount) {
        if (amount <= 0) {
            return "Invalid amount.";
        }

        if (cardNumber == null || cardNumber.length() != 16) {
            return "Payment failed: invalid card number.";
        }

        if (securityCode == null || securityCode.length() != 3) {
            return "Payment failed: invalid CVV.";
        }

        double fee = amount * feePercentage;
        double totalToBePayed = amount + fee;

        if (balance < totalToBePayed) {
            return "Payment failed: insufficient balance";
        }

        balance -= totalToBePayed;

        return "Paid " + totalToBePayed + " via Visa. Remaining balance: " + balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
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
        result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
        result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
        result = prime * result + ((securityCode == null) ? 0 : securityCode.hashCode());
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
        VisaPayment other = (VisaPayment) obj;
        if (cardNumber == null) {
            if (other.cardNumber != null)
                return false;
        } else if (!cardNumber.equals(other.cardNumber))
            return false;
        if (cardHolderName == null) {
            if (other.cardHolderName != null)
                return false;
        } else if (!cardHolderName.equals(other.cardHolderName))
            return false;
        if (expirationDate == null) {
            if (other.expirationDate != null)
                return false;
        } else if (!expirationDate.equals(other.expirationDate))
            return false;
        if (securityCode == null) {
            if (other.securityCode != null)
                return false;
        } else if (!securityCode.equals(other.securityCode))
            return false;
        if (Double.doubleToLongBits(feePercentage) != Double.doubleToLongBits(other.feePercentage))
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VisaPayment [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", expirationDate="
                + expirationDate + ", securityCode=" + securityCode + ", feePercentage=" + feePercentage + ", balance="
                + balance + "]";
    }

}
