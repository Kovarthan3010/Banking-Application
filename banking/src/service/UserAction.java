package service;

import DAO.GiftCard;
import DAO.GiftCardList;
import DAO.TransactionHistory;
import DAO.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class UserAction {
    private User currentUser;

    public UserAction(User currentUser) {
        this.currentUser = currentUser;
    }

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public void displayServices() {
        System.out.println("Below are the services provided : \n");
        System.out.println("1.Create Gift Card \n"
                + "2.Top Up Gift Card \n"
                + "3.Transaction History of gift cards \n"
                + "4.Block a gift card \n"
                + "5.Logout\n"
                + "6.My Account\n"
                + "7.Purchase\n"
                + "8.Redeem\n"
        );
        System.out.println("Please select the service : ");
        int serviceOption = sc.nextInt();
        switch (serviceOption) {
            case 1:
                createGiftCard();
                break;
            case 2:
                topUp();
                break;
            case 3:
                viewMyGiftCardTransactions();
                break;
            case 4:
                blockCard();
                break;
            case 5:
                System.out.println("Logout successful!!!");
                currentUser.setLoggedIn(false);
                currentUser = null;
                UserLogin userLogin = new UserLogin();
                userLogin.login();
                break;
            case 6:
                myAccount();
                break;
            case 7:
                purchase();
                break;
            case 8:
                redeem();
                break;
            default:
                System.out.println("Please select options from 1 to 5 : \n");
        }
    }

    private void redeem() {
        List<GiftCard> myGiftCardList = getMyGiftCards(currentUser);
        long totalRewardPoints = 0;
        for (GiftCard giftCard : myGiftCardList) {
            totalRewardPoints += giftCard.getRewardPoints();
            giftCard.setRewardPoints(0);
        }
        currentUser.setUserAccountBalance(currentUser.getUserAccountBalance() + totalRewardPoints);
        System.out.println("Added " + totalRewardPoints + " to main balance");
        displayServices();
    }

    private void purchase() {
        GiftCard purchaseInGiftCard = getGiftCard(currentUser);
        if (purchaseInGiftCard != null) {
            GiftCard toUse = purchaseInGiftCard;
            System.out.println("Enter the purchase amount :\n");
            double purchaseAmount = sc.nextDouble();
            if (purchaseAmount > toUse.getGiftCardBalance()) {
                System.out.println("Balance is less in GiftCard. Please topUp or use other cards \n");
                displayServices();
            } else {
                TransactionHistory transactionHistory = new TransactionHistory(
                        toUse.getGiftCardTransactions().size() + 1,
                        toUse.getGiftCardBalance(),
                        purchaseAmount,
                        toUse.getGiftCardBalance() - purchaseAmount,
                        LocalDateTime.now()
                );
                toUse.setGiftCardBalance(toUse.getGiftCardBalance() - purchaseAmount);
                toUse.setRewardPoints((long) ((purchaseAmount / 100) + toUse.getRewardPoints()));
                toUse.setGiftCardTransactions(transactionHistory);
                System.out.println("Purchase done. Available balance in card :" + toUse.getGiftCardBalance());

            }
        } else {
            System.out.println("null");
        }
        displayServices();

    }

    private GiftCard getGiftCard(User currentUser) {
        List<GiftCard> myGiftCardList = getMyGiftCards(currentUser);
        System.out.println("Below are your gift cards:\n");
        for (GiftCard inp : myGiftCardList) {
            System.out.println(inp.getGiftCardId() + "   " + inp.getGiftCardPin());
        }
        System.out.println("Please type the giftcardid to use :\n");
        long giftCardNumber = sc.nextLong();
        GiftCard toUse = null;
        for (GiftCard inp : myGiftCardList) {
            if (inp.getGiftCardId() == giftCardNumber) {
                toUse = inp;
            }
        }
        System.out.println("Please type the giftCard Pin :\n");
        long giftCardPin = sc.nextLong();
        if (giftCardPin == toUse.getGiftCardPin()) {
            return toUse;
        } else {
            System.out.println("Wrong Pin \n");
            return null;
        }
    }

    private void viewMyGiftCardTransactions() {
        List<GiftCard> currentUserGiftCards = currentUser.getUserGiftCardlist();
        for (GiftCard giftCard : currentUserGiftCards) {
            System.out.println("Below are the transactions in giftcard " + giftCard.getGiftCardId() + " \n");
            List<TransactionHistory> transactionHistories = giftCard.getGiftCardTransactions();
            for (TransactionHistory transactionHistory : transactionHistories) {
                System.out.println(transactionHistory.getTransactionId() + " "
                        + transactionHistory.getGiftCardBalancebeforePurchase() + " "
                        + transactionHistory.getPurchaseAmount() + " "
                        + transactionHistory.getGiftCardBalanceafterPurchase() + " "
                        + transactionHistory.getTransactionTime() + " \n");
            }
        }
        displayServices();
    }

    private void blockCard() {
        List<GiftCard> myGiftCardList = getMyGiftCards(currentUser);
        System.out.println("Below are your gift cards:\n");
        for (GiftCard inp : myGiftCardList) {
            System.out.println(inp.getGiftCardId() + "   " + inp.getGiftCardPin());
        }
        System.out.println("Please type the giftcardid to block :\n");
        long giftCardNumber = sc.nextLong();
        GiftCard toBlock = null;
        for (GiftCard inp : myGiftCardList) {
            if (inp.getGiftCardId() == giftCardNumber) {
                toBlock = inp;
            }
        }
        toBlock.setIsgiftCardBlocked(true);
        currentUser.setUserAccountBalance(currentUser.getUserAccountBalance() + toBlock.getGiftCardBalance());
        System.out.println("Blocked card " + toBlock.getGiftCardId() + "\n");
        displayServices();
    }

    private void myAccount() {
        System.out.println("User ID : " + currentUser.getUserId() + " \n"
                + "Account Balance :" + currentUser.getUserAccountBalance() + " \n");
        displayServices();
    }

    private void topUp() {
        List<GiftCard> myGiftCardList = getMyGiftCards(currentUser);
        System.out.println("Below are your gift cards:\n");
        for (GiftCard inp : myGiftCardList) {
            System.out.println(inp.getGiftCardId() + "   " + inp.getGiftCardPin());
        }
        System.out.println("Please type the giftcardid to topup :\n");
        long giftCardNumber = sc.nextLong();
        GiftCard toTopUp = null;
        for (GiftCard inp : myGiftCardList) {
            if (inp.getGiftCardId() == giftCardNumber) {
                toTopUp = inp;
            }
        }
        if (!toTopUp.isIsgiftCardBlocked()) {
            System.out.println("Please enter the amount : ");
            double amount = sc.nextDouble();
            if (amount > currentUser.getUserAccountBalance()) {
                System.out.println("Your balance is " + currentUser.getUserAccountBalance() + ". Please select lesser amount to topup.\n");
                topUp();
            } else {
                currentUser.setUserAccountBalance(currentUser.getUserAccountBalance() - amount);
                toTopUp.setGiftCardBalance(amount);
            }
        } else {
            System.out.println("Your giftcard is blocked. Please use other cards.\n");
        }
        displayServices();
    }

    private void createGiftCard() {
        long tempGiftCardId = random.nextInt(10000, 99999);
        while (GiftCardList.giftCardList.contains(tempGiftCardId)) {
            tempGiftCardId = random.nextInt(10000, 99999);
        }
        GiftCardList.giftCardList.add(tempGiftCardId);
        long tempGiftCardPin = random.nextInt(1000, 9999);
        GiftCard giftCard = new GiftCard(tempGiftCardId, tempGiftCardPin, 0,
                false, 0);
        currentUser.setUserGiftCardlist(giftCard);
        System.out.println("Gift card " + tempGiftCardId + " with pin " + tempGiftCardPin + " created and added to your account \n");
        displayServices();
    }

    private List<GiftCard> getMyGiftCards(User currentUser) {
        return currentUser.getUserGiftCardlist();
    }
}

