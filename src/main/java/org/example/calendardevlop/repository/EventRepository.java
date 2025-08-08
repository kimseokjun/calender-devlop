package org.example.calendardevlop.repository;


import org.example.calendardevlop.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
