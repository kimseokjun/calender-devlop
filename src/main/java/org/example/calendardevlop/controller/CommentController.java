package org.example.calendardevlop.controller;

import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.CommentSaveReqDto;
import org.example.calendardevlop.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{eventId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    public ResponseEntity<?> addComment(@PathVariable Long eventId, @RequestBody CommentSaveReqDto commentSaveReqDto){

        commentService.addComent(eventId, commentSaveReqDto);
        return null;
    }
}
