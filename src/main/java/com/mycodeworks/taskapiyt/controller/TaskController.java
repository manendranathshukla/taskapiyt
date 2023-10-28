package com.mycodeworks.taskapiyt.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycodeworks.taskapiyt.exceptions.TaskNotFoundException;
import com.mycodeworks.taskapiyt.models.Task;
import com.mycodeworks.taskapiyt.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired private TaskService taskService;


    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task t){
        return taskService.createTask(t);
    }


    @GetMapping("/tasks/{id}")
    @ResponseBody
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }


    @DeleteMapping("/tasks/{id}")
    @ResponseBody
    public String deleteTaskById(@PathVariable Long id){
        Task t= taskService.getTaskById(id).orElse(null);
        if(t != null){
            return  taskService.deleteTaskById(id);
        }else{
            throw new TaskNotFoundException(id);
        }
        
    }


    @PutMapping("/tasks")
    @ResponseBody
    public Task updateTask(@RequestBody Task t){
        return taskService.createTask(t);
    }

    @PatchMapping("/tasks/{id}")
    @ResponseBody
    public Task patchTask(@PathVariable Long id, @RequestBody Map<String,Object> updates){
    
        Task t= taskService.getTaskById(id).orElse(null);

        if(t != null){
            if(updates.containsKey("title")){
                t.setTitle((String)updates.get("title"));
            }
            
            if(updates.containsKey("completed")){
                t.setCompleted((Boolean)updates.get("completed"));
            }
            return taskService.createTask(t);
        }
        else{
            throw new TaskNotFoundException(id);
        }
    }

    
}
