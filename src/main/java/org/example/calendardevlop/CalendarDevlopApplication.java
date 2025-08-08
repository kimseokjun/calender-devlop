package org.example.calendardevlop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalendarDevlopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarDevlopApplication.class, args);
    }

}
