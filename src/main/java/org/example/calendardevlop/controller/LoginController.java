package org.example.calendardevlop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.LoginReqDto;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDto loginReqDto, HttpServletRequest request) {

        User user = loginService.findOne(loginReqDto);
        HttpSession session = request.getSession();
        session.setAttribute("USER_ID", user.getUser_id());

        return ResponseEntity.ok().body(user);
    }
}
