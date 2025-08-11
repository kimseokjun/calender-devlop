package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;

import org.example.calendardevlop.Config.PasswordEncoder;
import org.example.calendardevlop.Validator.UserValidator;
import org.example.calendardevlop.dto.userDto.*;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userrepository;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public UserSaveRespDto saveUser(UserSaveReqDto userSaveReqDto) {
        String encodedPassword = passwordEncoder.encode(userSaveReqDto.getPassword());
        userValidator.checkUsername(userSaveReqDto.getUsername());
        User user = new User(userSaveReqDto.getUsername(),userSaveReqDto.getEmail(),encodedPassword);
        user = userrepository.save(user);
        return new UserSaveRespDto(user.getUsername(),user.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UsergetAllRespDto> getAllUser() {
        ArrayList<UsergetAllRespDto> usergetAllRespDto = new ArrayList<>();
        List<User> users = userrepository.findAll();
        for (User user : users) {
            usergetAllRespDto.add(new UsergetAllRespDto(user.getUsername(),user.getEmail()));
        }

        return usergetAllRespDto;
    }
@Transactional
    public UserUpdateRespDto setUser(long id,UserUpdateReqDto userUpdateReqDto) {

    User user = userrepository.findById(id).orElseThrow(() -> new NoSuchElementException("유저가 없습니다."));
    user.updateUser(userUpdateReqDto.getUsername(),userUpdateReqDto.getEmail(),userUpdateReqDto.getPassword());
    user = userrepository.save(user);
    return new UserUpdateRespDto(user.getUsername(),user.getEmail());

    }

    public void deleteUser(long id) {
        User user = userrepository.findById(id).orElseThrow(() -> new NoSuchElementException("유저가 없습니다."));
        userrepository.delete(user);
    }
}
