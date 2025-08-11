package org.example.calendardevlop.Validator;

import org.example.calendardevlop.Exception.ErrorCode;
import org.example.calendardevlop.Exception.MyCustomException;
import org.springframework.stereotype.Component;



@Component
public class EventValidator {

    private static final int TITLE_MIN_LENGTH = 2;
    private static final int TITLE_MAX_LENGTH = 10;

    public void checkTitle(String title) {
        if(title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH){
            throw new MyCustomException(ErrorCode.EVENT_TITLE_SIZE);
        }
    }
}
