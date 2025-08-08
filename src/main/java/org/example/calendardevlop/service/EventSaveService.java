package org.example.calendardevlop.service;


import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.EventSaveReqDto;
import org.example.calendardevlop.dto.EventSaveRespDto;
import org.example.calendardevlop.entity.Event;
import org.example.calendardevlop.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventSaveService {

    private final EventRepository eventrepository;

    public EventSaveRespDto saveEvent(EventSaveReqDto dto) {
        Event event = new Event(dto.getTitle(),dto.getContent(),dto.getUserName());
        Event saveevent = eventrepository.save(event);

        return new EventSaveRespDto(saveevent.getEventName(),saveevent.getContent(),saveevent.getUserName(),saveevent.getCreatedAt(),saveevent.getModifiedAt());
    }


}
