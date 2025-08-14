package org.example.calendardevlop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class CommentSaveReqDto {

    @NotBlank(message = "유저를 찾을수 없습니다.")
    private Long userId;
    @NotBlank(message = "내용을 입력하세요")
    private String content;
}
