package org.example.calendardevlop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Event extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String eventName;
    String content;
    String userName;

    public void updateEvent(String eventName, String content){
        this.eventName = eventName;
        this.content = content;
    }

    public Event(String eventName, String content, String userName) {
        this.eventName = eventName;
        this.content = content;
        this.userName = userName;
    }

}
