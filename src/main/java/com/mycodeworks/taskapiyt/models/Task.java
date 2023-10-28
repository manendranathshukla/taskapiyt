package com.mycodeworks.taskapiyt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean completed;
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
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public Task(long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public Task() {
    }
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
    }

    
    
}
