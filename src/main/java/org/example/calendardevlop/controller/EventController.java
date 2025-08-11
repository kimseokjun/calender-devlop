package org.example.calendardevlop.controller;



import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.eventDto.*;
import org.example.calendardevlop.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class EventController {


    private final EventService eventservice;

    @PostMapping("")
    public ResponseEntity<EventSaveRespDto> saveEvent(@RequestBody EventSaveReqDto eventSaveReqDto) {

        return ResponseEntity.ok( eventservice.saveEvent(eventSaveReqDto));
    }

    @GetMapping("")
    public ResponseEntity<List<EventgetAllRespDto>> getAllEvent() {

        return ResponseEntity.ok(eventservice.getAllEvent());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventUpdateRespDto>  updateEvent(@PathVariable long id, @RequestBody EventUpdateReqDto eventUpdateReqDto) {
        return ResponseEntity.ok(eventservice.updateEvent(id, eventUpdateReqDto));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventservice.deleteEvent(id);
    }
}
