package com.mycodeworks.taskapiyt.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id){
        super("Task with ID "+ id+ " not found!");
    }
    
}
