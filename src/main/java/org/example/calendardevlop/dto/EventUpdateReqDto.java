package org.example.calendardevlop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventUpdateReqDto {
    private final String eventName;
    private final String content;
}
