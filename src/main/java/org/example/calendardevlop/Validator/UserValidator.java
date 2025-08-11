package org.example.calendardevlop.Validator;


import org.example.calendardevlop.Exception.ErrorCode;
import org.example.calendardevlop.Exception.MyCustomException;
import org.springframework.stereotype.Component;



@Component
public class UserValidator {

    private static final int USERMAXLEGTH = 4;

    public void checkUsername(String username) {
        if(username.length() >USERMAXLEGTH){
            throw new MyCustomException(ErrorCode.USERNAME_SIZE);
        }
    }

}
