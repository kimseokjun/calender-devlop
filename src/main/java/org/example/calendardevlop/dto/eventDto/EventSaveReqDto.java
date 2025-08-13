package org.example.calendardevlop.dto.eventDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventSaveReqDto {

    private final String title;
    private final String content;
   // private final String userName;
    private final long userId;
}
