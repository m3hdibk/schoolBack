/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:31 PM
 */

package com.school.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lessons")
public class Lesson implements Serializable {

    private static final long serialVersionUID = -8300632676145532286L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "finished")
    private boolean finished;

    @Column(name = "startTime", columnDefinition = "TIMESTAMP")
    private Date startTime;

    @ManyToOne
    @JoinColumn(name = "loginDetails_id")
    private LoginDetails teacher;

    public Lesson() {}

    public Lesson(String title, String description, boolean finished, Date startTime, LoginDetails teacher) {
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.startTime = startTime;
        this.teacher = teacher;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Cours [id=" + id + ", title=" + title + ", desc=" + description + ", finished=" + finished + "]";
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
}