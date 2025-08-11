package org.example.calendardevlop.dto.userDto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserSaveReqDto {

    @NotBlank(message = "이름을 입력해주세요")
    private String username;
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
}
