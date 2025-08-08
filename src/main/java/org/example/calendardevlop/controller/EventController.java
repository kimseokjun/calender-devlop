package org.example.calendardevlop.controller;



import lombok.RequiredArgsConstructor;
import org.example.calendardevlop.dto.EventSaveReqDto;
import org.example.calendardevlop.dto.EventSaveRespDto;
import org.example.calendardevlop.service.EventSaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class EventController {


    private final EventSaveService eventservice;

    @PostMapping("/")
    public ResponseEntity<EventSaveRespDto> saveEvent(@RequestBody EventSaveReqDto eventSaveReqDto) {

        return ResponseEntity.ok( eventservice.saveEvent(eventSaveReqDto));
    }

}
