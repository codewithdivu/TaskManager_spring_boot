package com.example.taskmanager;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
public class TaskService {
    private final List<String> tasks = new ArrayList<String>();

    public List<String> getAllTasks(){
        return tasks;
    }

    public String addTask(String task){
        tasks.add(task);
        return task;
    }

    public TaskRequest createTask(TaskRequest request){
        return request;
    }
}
