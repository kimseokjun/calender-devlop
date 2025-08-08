package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.EventSaveReqDto;
import org.example.calendardevlop.dto.EventSaveRespDto;
import org.example.calendardevlop.dto.EventgetAllRespDto;
import org.example.calendardevlop.entity.Event;
import org.example.calendardevlop.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventSaveService {

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
}
