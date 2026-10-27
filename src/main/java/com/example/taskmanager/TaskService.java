package com.example.taskmanager;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Task> getAllTasks(){
        return new ArrayList<>(tasks);
    }

    public Optional<Task> getTaskById(Long id){
        return tasks.stream().filter(task -> task.id().equals(id)).findFirst();
    }

    public Task createTask(TaskRequest request){
        Task task = new Task(nextId.getAndIncrement(),request.title(),request.completed());
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(Long id, TaskRequest request){
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).id().equals(id)){
                Task updatedTask = new Task(
                        id,
                        request.title(),
                        request.completed()
                );
                tasks.set(i, updatedTask);
                return Optional.of(updatedTask);
            }
        }
        return Optional.empty();
    }

    public boolean deleteTask(long id){
        return tasks.removeIf(task -> task.id().equals(id));
    }
}
