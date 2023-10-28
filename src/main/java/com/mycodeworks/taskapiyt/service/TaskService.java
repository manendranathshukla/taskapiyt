package com.mycodeworks.taskapiyt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycodeworks.taskapiyt.models.Task;
import com.mycodeworks.taskapiyt.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired private TaskRepository taskRepo;

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public Task createTask(Task t){
        return taskRepo.save(t);
    }

    public Optional<Task> getTaskById(Long id){
    
        Optional<Task> t=taskRepo.findById(id);
        return t;
    }

    public String deleteTaskById(Long id) {
        taskRepo.deleteById(id);
        return "Task deleted successfully!";
    }

    
}
