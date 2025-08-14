package org.example.calendardevlop.dto.userDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserUpdateReqDto {

    @NotBlank(message = "이름을 입력하세요")
    private String username;
    @NotBlank(message = "메일을 입력하세요")
    private String email;
    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;

}
