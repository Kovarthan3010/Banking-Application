package service;

import DAO.User;

import java.util.Scanner;

public class UserAction {
    private User currentUser;

    public UserAction(User currentUser) {
        this.currentUser = currentUser;
    }
    Scanner sc=new Scanner(System.in);
    public void displayServices()
    {
        System.out.println("Below are the services provided : \n");
        System.out.println("1.Create Gift Card \n"
                +"2.Top Up Gift Card \n"
                +"3.Transaction History of gift cards \n"
                +"4.Block a gift card \n"
                +"5.Logout\n"
                );
        System.out.println("Please select the service : ");
        int serviceOption = sc.nextInt();
        switch(serviceOption)
        {
            case 1:
                break;
            case 2:
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
            default:
                System.out.println("Please select options from 1 to 5 : \n");
        }
    }
}
