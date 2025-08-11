package org.example.calendardevlop.Validator;


import jakarta.validation.ValidationException;
import org.example.calendardevlop.Config.ErrorCode;
import org.example.calendardevlop.Config.MyCustomException;
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
