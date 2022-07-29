package store.validators;

import store.exceptions.ValidatorException;

public class UserDataValidator {
    public static void validateLogin(String login){
        if(login.length()<5){
            throw new ValidatorException();
        }
    }
    public static void validatePassword(String password){
        if(password.length()<5) {
            throw new ValidatorException();
        }
    }
    public static void validatePasswordMatch(String pass1, String pass2){
        if(!pass1.equals(pass2)){
            throw new ValidatorException();
        }
    }
}
