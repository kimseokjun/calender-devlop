package org.example.calendardevlop.dto.eventDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventUpdateReqDto {
    @NotBlank(message = "제목을 입력하세요")
    private final String eventName;
    @NotBlank(message = "내용을 입력하세요")
    private final String content;
}
