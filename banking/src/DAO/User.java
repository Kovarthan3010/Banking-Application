package DAO;

import java.util.List;

public class User {
    private String userId;
    private String userPassWord;
    private double userAccountBalance;
    private boolean isLoggedIn;
    private List<GiftCard> userGiftCardlist;

    public User(String userId, String userPassWord, double userAccountBalance, boolean isLoggedIn, List<GiftCard> userGiftCardlist) {
        this.userId = userId;
        this.userPassWord = userPassWord;
        this.userAccountBalance = userAccountBalance;
        this.isLoggedIn = isLoggedIn;
        this.userGiftCardlist = userGiftCardlist;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public double getUserAccountBalance() {
        return userAccountBalance;
    }

    public void setUserAccountBalance(double userAccountBalance) {
        this.userAccountBalance = userAccountBalance;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public List<GiftCard> getUserGiftCardlist() {
        return userGiftCardlist;
    }

    public void setUserGiftCardlist(List<GiftCard> userGiftCardlist) {
        this.userGiftCardlist = userGiftCardlist;
    }
}
