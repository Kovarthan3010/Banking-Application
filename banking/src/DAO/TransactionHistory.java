package DAO;

import java.time.LocalDateTime;

public class TransactionHistory {
    private long transactionId;
    private double giftCardBalancebeforePurchase;
    private double purchaseAmount;
    private double giftCardBalanceafterPurchase;
    private LocalDateTime transactionTime;

    public TransactionHistory(long transactionId, double giftCardBalancebeforePurchase, double purchaseAmount, double giftCardBalanceafterPurchase, LocalDateTime transactionTime) {
        this.transactionId = transactionId;
        this.giftCardBalancebeforePurchase = giftCardBalancebeforePurchase;
        this.purchaseAmount = purchaseAmount;
        this.giftCardBalanceafterPurchase = giftCardBalanceafterPurchase;
        this.transactionTime = transactionTime;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getGiftCardBalancebeforePurchase() {
        return giftCardBalancebeforePurchase;
    }

    public void setGiftCardBalancebeforePurchase(double giftCardBalancebeforePurchase) {
        this.giftCardBalancebeforePurchase = giftCardBalancebeforePurchase;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getGiftCardBalanceafterPurchase() {
        return giftCardBalanceafterPurchase;
    }

    public void setGiftCardBalanceafterPurchase(double giftCardBalanceafterPurchase) {
        this.giftCardBalanceafterPurchase = giftCardBalanceafterPurchase;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
