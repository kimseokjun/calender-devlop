package org.example.calendardevlop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;

    @ManyToOne(fetch = FetchType.LAZY) //유저 한명은 여러개의 댓글을 쓸수있다. (뒤에꺼(One)가 밑이오는 필드가 되도록)
    @JoinColumn(name = "user_id")
    User user;


    @ManyToOne(fetch = FetchType.LAZY)  //게시글 하나에는 여러개의 댓글이 달릴수있다.
    @JoinColumn(name = "event_id")
    Event event;

    public Comment(String content, User user, Event event) {
        this.content = content;
        this.user = user;
        this.event = event;
    }
}
