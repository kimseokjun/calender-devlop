package org.example.calendardevlop.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.calendardevlop.dto.userDto.*;

import org.example.calendardevlop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserSaveReqDto userSaveReqDto) {
        return ResponseEntity.ok().body(userService.saveUser(userSaveReqDto));
    }

    @GetMapping("")
    public ResponseEntity<List<UsergetAllRespDto>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdateRespDto> updateUser(@PathVariable long id, @RequestBody UserUpdateReqDto userUpdateReqDto){
        return ResponseEntity.ok().body(userService.setUser(id,userUpdateReqDto));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
