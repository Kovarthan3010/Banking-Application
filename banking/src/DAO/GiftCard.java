package DAO;

import java.util.List;

public class GiftCard {
    private long giftCardId;
    private long giftCardPin;
    private double giftCardBalance;
    private int giftCardRedeemPoints;
    private boolean isgiftCardBlocked;
    private List<TransactionHistory> giftCardTransactions;
    private long rewardPoints;

    public GiftCard(long giftCardId, long giftCardPin, double giftCardBalance, int giftCardRedeemPoints, boolean isgiftCardBlocked, List<TransactionHistory> giftCardTransactions, long rewardPoints) {
        this.giftCardId = giftCardId;
        this.giftCardPin = giftCardPin;
        this.giftCardBalance = giftCardBalance;
        this.giftCardRedeemPoints = giftCardRedeemPoints;
        this.isgiftCardBlocked = isgiftCardBlocked;
        this.giftCardTransactions = giftCardTransactions;
        this.rewardPoints = rewardPoints;
    }

    public long getGiftCardId() {
        return giftCardId;
    }

    public void setGiftCardId(long giftCardId) {
        this.giftCardId = giftCardId;
    }

    public long getGiftCardPin() {
        return giftCardPin;
    }

    public void setGiftCardPin(long giftCardPin) {
        this.giftCardPin = giftCardPin;
    }

    public double getGiftCardBalance() {
        return giftCardBalance;
    }

    public void setGiftCardBalance(double giftCardBalance) {
        this.giftCardBalance = giftCardBalance;
    }

    public int getGiftCardRedeemPoints() {
        return giftCardRedeemPoints;
    }

    public void setGiftCardRedeemPoints(int giftCardRedeemPoints) {
        this.giftCardRedeemPoints = giftCardRedeemPoints;
    }

    public boolean isIsgiftCardBlocked() {
        return isgiftCardBlocked;
    }

    public void setIsgiftCardBlocked(boolean isgiftCardBlocked) {
        this.isgiftCardBlocked = isgiftCardBlocked;
    }

    public List<TransactionHistory> getGiftCardTransactions() {
        return giftCardTransactions;
    }

    public void setGiftCardTransactions(List<TransactionHistory> giftCardTransactions) {
        this.giftCardTransactions = giftCardTransactions;
    }

    public long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

}
