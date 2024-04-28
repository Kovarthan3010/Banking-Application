package DAO;

import java.util.ArrayList;
import java.util.List;

public class GiftCard {
    private long giftCardId;
    private long giftCardPin;
    private double giftCardBalance;
    private boolean isgiftCardBlocked;
    private List<TransactionHistory> giftCardTransactions;
    private long rewardPoints;

    public GiftCard(long giftCardId, long giftCardPin, double giftCardBalance, boolean isgiftCardBlocked, long rewardPoints) {
        this.giftCardId = giftCardId;
        this.giftCardPin = giftCardPin;
        this.giftCardBalance = giftCardBalance;
        this.isgiftCardBlocked = isgiftCardBlocked;
        this.giftCardTransactions = new ArrayList<>();
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

    public boolean isIsgiftCardBlocked() {
        return isgiftCardBlocked;
    }

    public void setIsgiftCardBlocked(boolean isgiftCardBlocked) {
        this.isgiftCardBlocked = isgiftCardBlocked;
    }

    public List<TransactionHistory> getGiftCardTransactions() {
        return giftCardTransactions;
    }

    public void setGiftCardTransactions(TransactionHistory transactionHistory) {
        giftCardTransactions.add(transactionHistory);
    }

    public long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

}
