package org.example.calendardevlop.controller;



import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.calendardevlop.dto.eventDto.*;
import org.example.calendardevlop.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class EventController {


    private final EventService eventservice;

    @PostMapping("")
    public ResponseEntity<?> saveEvent(@Valid @RequestBody EventSaveReqDto eventSaveReqDto) {
//        if(bindingResult.hasErrors()) {
//            log.info("errors = {}",bindingResult.getAllErrors().toString());
//            return ResponseEntity.badRequest().body("error");
//        }
        return ResponseEntity.ok( eventservice.saveEvent(eventSaveReqDto));
    }

//    @GetMapping("")
//    public ResponseEntity<List<EventgetAllRespDto>> getAllEvent() {
//
//        return ResponseEntity.ok(eventservice.getAllEvent());
//    }
    @GetMapping("")
    public ResponseEntity<Page<EventgetAllRespDto>> getAllEventPage(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(eventservice.getAllEvent(page,size));
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
