package service;


import DAO.User;
import DAO.UserList;

import java.util.Scanner;

public class UserLogin {
    public UserLogin() {
    }

    String userName;
    String passWord;
    String encryptedPassWord;
    Scanner sc = new Scanner(System.in);
    PasswordHandler passwordHandler = new PasswordHandler();

    public void login() {
        System.out.println("Please select the options below : ");
        System.out.println("1 . New user");
        System.out.println("2 . User Login");
        int userSiginOption = sc.nextInt();
        switch (userSiginOption) {
            case 1:
                newUserSignin();
                break;
            case 2:
                existingUserLogin();
                break;
            default:
                System.out.println();
                System.out.println("!**** Please select the option 1 or 2 ******!");
                System.out.println();
                login();
                break;
        }
    }

    private void newUserSignin() {
        User currentUser = null;
        boolean isUserAlreadyRegistered =false;
        System.out.println("Please enter the new username : ");
        userName = sc.next();
        sc.nextLine();
        for(User user : UserList.userList)
        {
            if(user.getUserId().equals(userName))
            {
                currentUser=user;
                isUserAlreadyRegistered=true;
            }
        }
        if(isUserAlreadyRegistered)
        {
            System.out.println("\n!********You are already registered . Please login *********!\n");
            existingUserLogin();
        }
        System.out.println("Please enter the new password : ");
        passWord = sc.next();
        sc.nextLine();
        encryptedPassWord = passwordHandler.encryptor(passWord);
        User user = new User(userName, encryptedPassWord, 1000, false);
        UserList.userList.add(user);
        System.out.println("User account created successfully \n");
        login();
    }

    private void existingUserLogin() {
        User currentUser = null;
        System.out.println("Please enter username : ");
        userName = sc.next();
        sc.nextLine();
        boolean isUserAlreadyRegistered=false;
        for(User user : UserList.userList)
        {
            if(user.getUserId().equals(userName))
            {
                currentUser=user;
                isUserAlreadyRegistered=true;
            }
        }
        if(!isUserAlreadyRegistered)
        {
            System.out.println("\n!********You are not registered Yet. Please create an account *********!\n");
            login();
        }
        System.out.println("Please enter password : ");
        passWord = sc.next();
        sc.nextLine();
        encryptedPassWord = passwordHandler.encryptor(passWord);
        if(!encryptedPassWord.equals(currentUser.getUserPassWord()))
        {
            System.out.println("\nPassword incorrect. Please try again\n");
            existingUserLogin();
        }
        else {
            System.out.println("\nWelcome "+currentUser.getUserId()+" \n");
            currentUser.setLoggedIn(true);
            UserAction userAction = new UserAction(currentUser);
            userAction.displayServices();
        }
    }

}
