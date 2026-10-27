package com.example.taskmanager;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<String> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public String addTask(@RequestBody String task){
        return taskService.addTask(task);
    }

    @PostMapping("/json")
    public TaskRequest createTask(@Valid @RequestBody TaskRequest request){
        return taskService.createTask(request);
    }
}
