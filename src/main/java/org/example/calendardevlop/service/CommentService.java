package org.example.calendardevlop.service;

import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.Exception.MyCustomException;
import org.example.calendardevlop.dto.CommentSaveReqDto;
import org.example.calendardevlop.entity.Comment;
import org.example.calendardevlop.entity.Event;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.CommentRepository;
import org.example.calendardevlop.repository.EventRepository;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static org.example.calendardevlop.Exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public void addComent(Long eventId, CommentSaveReqDto commentSaveReqDto) {

        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NoSuchElementException("존재하지 않는 이벤트"));
        User user =  userRepository.findById(commentSaveReqDto.getUserId()).orElseThrow(() -> new MyCustomException(USER_NOT_FOUND));

        commentRepository.save(new Comment(commentSaveReqDto.getContent(), user, event));
    }
}
