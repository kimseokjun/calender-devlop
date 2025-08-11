package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.userDto.UserSaveReqDto;
import org.example.calendardevlop.dto.userDto.UserSaveRespDto;
import org.example.calendardevlop.dto.userDto.UsergetAllRespDto;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userrepository;
    public UserSaveRespDto saveUser(UserSaveReqDto userSaveReqDto) {
        User user = new User(userSaveReqDto.getUsername(),userSaveReqDto.getEmail(),userSaveReqDto.getPassword());
        user = userrepository.save(user);

        return new UserSaveRespDto(user.getUsername(),user.getEmail());
    }

    public List<UsergetAllRespDto> getAllUser() {
        ArrayList<UsergetAllRespDto> usergetAllRespDto = new ArrayList<>();
        List<User> users = userrepository.findAll();
        for (User user : users) {
            usergetAllRespDto.add(new UsergetAllRespDto(user.getUsername(),user.getEmail()));
        }

        return usergetAllRespDto;
    }
}
