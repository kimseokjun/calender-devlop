package org.example.calendardevlop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String eventName;
    private String content;
    private String userName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updateEvent(String eventName, String content){
        this.eventName = eventName;
        this.content = content;
    }

    public Event(String eventName, String content, String userName) {
        this.eventName = eventName;
        this.content = content;
        this.userName = userName;
    }
    public Event(String eventName, String content, User user) {
        this.eventName = eventName;
        this.content = content;
        this.user = user;
    }


}
