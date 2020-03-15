/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 5:36 PM
 */

package com.school.demo.api;

import com.school.demo.model.Lesson;
import com.school.demo.model.LoginDetails;
import com.school.demo.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;

    @GetMapping("/lessons")
    public ResponseEntity<List<Lesson>> getAllLessons(@RequestParam(required = false) String title) {
        try {
            List<Lesson> lessons = new ArrayList<>();

            if (title == null)
                lessons.addAll(lessonRepository.findAll());
            else
                lessons.addAll(lessonRepository.findByTitleContaining(title));

            if (lessons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(lessons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lessons/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable("id") long id) {
        Optional<Lesson> lessonData = lessonRepository.findById(id);

        return lessonData.map(lesson -> new ResponseEntity<>(lesson, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/lessons")
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        try {
            LoginDetails user = new LoginDetails();
            //TODO
            user.setId(15L);
            Lesson _lesson = lessonRepository
                    .save(new Lesson(lesson.getTitle(), lesson.getDescription(), false, new Date(), user));
            return new ResponseEntity<>(_lesson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/lessons/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable("id") long id, @RequestBody Lesson lesson) {
        Optional<Lesson> lessonData = lessonRepository.findById(id);

        if (lessonData.isPresent()) {
            Lesson _lesson = lessonData.get();
            _lesson.setTitle(lesson.getTitle());
            _lesson.setDescription(lesson.getDescription());
            _lesson.setFinished(lesson.isFinished());
            _lesson.setStartTime(lesson.getStartTime());
            return new ResponseEntity<>(lessonRepository.save(_lesson), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/lessons/{id}")
    public ResponseEntity<HttpStatus> deleteLesson(@PathVariable("id") long id) {
        try {
            lessonRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/lessons")
    public ResponseEntity<HttpStatus> deleteAllLessons() {
        try {
            lessonRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/lessons/published")
    public ResponseEntity<List<Lesson>> findByPublished() {
        try {
            List<Lesson> lessons = lessonRepository.findByFinished(true);

            if (lessons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lessons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}