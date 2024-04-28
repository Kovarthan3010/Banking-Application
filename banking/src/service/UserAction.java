package service;

import DAO.GiftCard;
import DAO.GiftCardList;
import DAO.User;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserAction {
    private User currentUser;

    public UserAction(User currentUser) {
        this.currentUser = currentUser;
    }
    Scanner sc=new Scanner(System.in);
    Random random = new Random();
    public void displayServices()
    {
        System.out.println("Below are the services provided : \n");
        System.out.println("1.Create Gift Card \n"
                +"2.Top Up Gift Card \n"
                +"3.Transaction History of gift cards \n"
                +"4.Block a gift card \n"
                +"5.Logout\n"
                +"6.My Account\n"
                );
        System.out.println("Please select the service : ");
        int serviceOption = sc.nextInt();
        switch(serviceOption)
        {
            case 1:
                createGiftCard();
                break;
            case 2:
                topUp();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5 :
                System.out.println("Logout successful!!!");
                currentUser.setLoggedIn(false);
                currentUser = null;
                UserLogin userLogin=new UserLogin();
                userLogin.login();
                break;
            case 6:
                myAccount();
                break;
            default:
                System.out.println("Please select options from 1 to 5 : \n");
        }
    }

    private void myAccount() {
        System.out.println("User ID : "+currentUser.getUserId()+" \n"
        +"Account Balance :"+currentUser.getUserAccountBalance()+" \n");
        displayServices();
    }

    private void topUp() {
        List<GiftCard> myGiftCardList = getMyGiftCards(currentUser);
        System.out.println("Below are your gift cards:\n");
        for(GiftCard inp : myGiftCardList)
        {
            System.out.println(inp.getGiftCardId()+"   "+inp.getGiftCardPin());
        }
        System.out.println("Please type the giftcardid to topup :\n");
        long giftCardNumber = sc.nextLong();
        GiftCard toTopUp=null;
        for(GiftCard inp : myGiftCardList)
        {
            if(inp.getGiftCardId()==giftCardNumber)
            {
                toTopUp = inp;
            }
        }
        System.out.println("Please enter the amount : ");
        double amount = sc.nextDouble();
        if(amount > currentUser.getUserAccountBalance())
        {
            System.out.println("Your balance is "+currentUser.getUserAccountBalance()+". Please select lesser amount to topup.\n");
            topUp();
        }
        else {
            currentUser.setUserAccountBalance(currentUser.getUserAccountBalance()-amount);
            toTopUp.setGiftCardBalance(amount);
        }
        displayServices();
    }

    private void createGiftCard() {
        long tempGiftCardId = random.nextInt(10000,99999);
        while(GiftCardList.giftCardList.contains(tempGiftCardId))
        {
            tempGiftCardId = random.nextInt(10000,99999);
        }
        GiftCardList.giftCardList.add(tempGiftCardId);
        long tempGiftCardPin = random .nextInt(1000,9999);
        GiftCard giftCard = new GiftCard(tempGiftCardId,tempGiftCardPin,0,
                false,0);
        currentUser.setUserGiftCardlist(giftCard);
        System.out.println("Gift card "+ tempGiftCardId +" with pin "+ tempGiftCardPin+" created and added to your account \n");
        displayServices();
    }

    private List<GiftCard> getMyGiftCards(User currentUser)
    {
        return currentUser.getUserGiftCardlist();
    }
}
