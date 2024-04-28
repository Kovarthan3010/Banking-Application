package service;


public class PasswordHandler {

    public String encryptor(String password) {
        String output = "";
        for (int i = 0; i < password.length(); i++) {
            int actualAscii = (int) password.charAt(i);
            output += (char) actualAscii + 1;
        }
        return output;
    }


}
