package org.example.calendardevlop.repository;

import org.example.calendardevlop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
