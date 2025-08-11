package org.example.calendardevlop.Validator;

import org.example.calendardevlop.Config.ErrorCode;
import org.example.calendardevlop.Config.MyCustomException;
import org.springframework.stereotype.Component;



@Component
public class EventValidator {

    private static final int TITLEMMINLEGTH = 2;
    private static final int TITLEMAXLEGTH = 10;

    public void checktitle(String title) {
        if(title.length() <TITLEMMINLEGTH || title.length() > TITLEMAXLEGTH){
            throw new MyCustomException(ErrorCode.EVENT_TITLE_SIZE);
        }
    }
}
