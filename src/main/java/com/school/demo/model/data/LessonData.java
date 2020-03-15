/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:28 PM
 */

package com.school.demo.model.data;

import com.school.demo.model.LoginDetails;

import java.util.Date;

public class LessonData {


    private long id;

    private String title;

    private String description;

    private boolean finished;

    private Date startTime;

    private LoginDetails teacher;

    public LessonData() {
    }

    public LessonData(long id, String title, String description, boolean finished, Date startTime,
                      LoginDetails teacher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.startTime = startTime;
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public LoginDetails getTeacher() {
        return teacher;
    }

    public void setTeacher(LoginDetails teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "LessonData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                ", startTime=" + startTime +
                ", teacher=" + teacher +
                '}';
    }
}
