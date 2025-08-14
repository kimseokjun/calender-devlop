package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.Exception.MyCustomException;
import org.example.calendardevlop.Validator.EventValidator;
import org.example.calendardevlop.dto.eventDto.*;
import org.example.calendardevlop.entity.Event;
import org.example.calendardevlop.entity.User;
import org.example.calendardevlop.repository.EventRepository;
import org.example.calendardevlop.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.example.calendardevlop.Exception.ErrorCode.EVENT_NOT_FOUND;
import static org.example.calendardevlop.Exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EventService {


    private final EventRepository eventrepository;
    private final UserRepository userrepository;
    private final EventValidator eventValidator;

    @Transactional
    public EventSaveRespDto saveEvent(EventSaveReqDto dto) {
        eventValidator.checkTitle(dto.getTitle());
        User user = userrepository.findById(dto.getUserId()).orElseThrow(()  -> new MyCustomException(USER_NOT_FOUND));
        Event event = new Event(dto.getTitle(),dto.getContent(),user);
        Event saveevent = eventrepository.save(event);

        return new EventSaveRespDto(saveevent.getEventName(),saveevent.getContent(),user.getUsername(),saveevent.getCreatedAt(),saveevent.getModifiedAt());
    }



    @Transactional(readOnly = true)
    public Page<EventgetAllRespDto> getAllEvent(int page, int size) {

        Pageable pageable =  PageRequest.of(page, size);

        Page<Event> results = eventrepository.findAll(pageable);


//        List<Event> events = eventrepository.findAll();
//        List<EventgetAllRespDto>  eventgetAllRespDto = new ArrayList<>();
//        for (Event event : events) {
//            eventgetAllRespDto.add(new EventgetAllRespDto(event.getEventName(),event.getContent(),event.getUserName(),event.getCreatedAt(),event.getModifiedAt()));
//        }

        return results.map( e -> new EventgetAllRespDto(e.getEventName(),e.getContent(),e.getUserName(),e.getCreatedAt(),e.getModifiedAt()));
    }

    public EventUpdateRespDto updateEvent(long id, EventUpdateReqDto eventUpdateReqDto) {

         Event event = eventrepository.findById(id).orElseThrow(()->  new MyCustomException(EVENT_NOT_FOUND));
         event.updateEvent(eventUpdateReqDto.getEventName(),eventUpdateReqDto.getContent());

        return new EventUpdateRespDto(event.getEventName(),event.getContent(),event.getUserName(),event.getCreatedAt(),event.getModifiedAt());
    }

    public void deleteEvent(long id) {

        Event event = eventrepository.findById(id).orElseThrow(()-> new MyCustomException(EVENT_NOT_FOUND));
        eventrepository.delete(event);
    }
}
