/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/21/20, 4:09 PM
 */

package com.school.demo.repositories;

import com.school.demo.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByFinished(boolean finished);
    List<Lesson> findByTitleContaining(String title);
}
