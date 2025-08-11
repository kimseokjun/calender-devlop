package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.Config.MyCustomException;
import org.example.calendardevlop.dto.eventDto.*;
import org.example.calendardevlop.entity.Event;
import org.example.calendardevlop.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.calendardevlop.Config.ErrorCode.EVENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventrepository;

    @Transactional
    public EventSaveRespDto saveEvent(EventSaveReqDto dto) {
        Event event = new Event(dto.getTitle(),dto.getContent(),dto.getUserName());
        Event saveevent = eventrepository.save(event);

        return new EventSaveRespDto(saveevent.getEventName(),saveevent.getContent(),saveevent.getUserName(),saveevent.getCreatedAt(),saveevent.getModifiedAt());
    }


    @Transactional(readOnly = true)
    public List<EventgetAllRespDto> getAllEvent() {

        List<Event> events = eventrepository.findAll();
        List<EventgetAllRespDto>  eventgetAllRespDto = new ArrayList<>();
        for (Event event : events) {
            eventgetAllRespDto.add(new EventgetAllRespDto(event.getEventName(),event.getContent(),event.getUserName(),event.getCreatedAt(),event.getModifiedAt()));
        }

        return eventgetAllRespDto;
    }

    public EventUpdateRespDto updateEvent(long id, EventUpdateReqDto eventUpdateReqDto) {

         Event event = eventrepository.findById(id).orElseThrow(()->  new MyCustomException(EVENT_NOT_FOUND));
         event.updateEvent(eventUpdateReqDto.getEventName(),eventUpdateReqDto.getContent());
         Event save = eventrepository.save(event);

        return new EventUpdateRespDto(save.getEventName(),save.getContent(),save.getUserName(),save.getCreatedAt(),save.getModifiedAt());
    }

    public void deleteEvent(long id) {

        Event event = eventrepository.findById(id).orElseThrow(()-> new NoSuchElementException("해당 일정이 존재하지 않는다."));
        eventrepository.delete(event);
    }
}
