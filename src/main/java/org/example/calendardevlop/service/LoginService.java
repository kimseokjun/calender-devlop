package org.example.calendardevlop.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.Exception.ErrorCode;
import org.example.calendardevlop.Exception.MyCustomException;
import org.example.calendardevlop.dto.LoginReqDto;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    @Transactional
    public User findOne(LoginReqDto loginReqDto) {

        User user = userRepository.getByEmail(loginReqDto.getEmail());
        if (user == null) {
            throw new MyCustomException(ErrorCode.USER_NOT_FOUND);
//            throw new NullPointerException("존재하지 않는 유저입니다.");
        }

        if(!loginReqDto.getPassword().equals(user.getPassword())) {
            throw new MyCustomException(ErrorCode.WRONG_EMAIL_PASSWORD);
        }
        return user;
    }
}
