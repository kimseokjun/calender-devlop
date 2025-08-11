package org.example.calendardevlop.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("USR-001","해당 유저를 찾을 수 없습니다."),
    EVENT_NOT_FOUND("EVT-001","해당 일정을 찾을 수 없습니다"),
    WRONG_EMAIL_PASSWORD("USR-003", "이메일 혹은 비밀번호가 틀렸습니다.");

    private final String code;
    private final String message;
}
