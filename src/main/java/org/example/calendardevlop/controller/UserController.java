package org.example.calendardevlop.controller;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.userDto.*;

import org.example.calendardevlop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserSaveRespDto> saveUser(@RequestBody UserSaveReqDto userSaveReqDto){

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
