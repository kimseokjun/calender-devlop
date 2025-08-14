package org.example.calendardevlop.dto.eventDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventSaveReqDto {

    @NotBlank(message = "제목을 입력하세요")
    private final String title;
    @NotBlank(message = "내용을 입력하세요")
    private final String content;
    @NotNull
    private final long userId;
}
