package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.userDto.UserSaveReqDto;
import org.example.calendardevlop.dto.userDto.UserSaveRespDto;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userrepository;
    public UserSaveRespDto saveUser(UserSaveReqDto userSaveReqDto) {
        User user = new User(userSaveReqDto.getUsername(),userSaveReqDto.getEmail(),userSaveReqDto.getPassword());
        user = userrepository.save(user);

        return new UserSaveRespDto(user.getUsername(),user.getEmail());
    }
}
