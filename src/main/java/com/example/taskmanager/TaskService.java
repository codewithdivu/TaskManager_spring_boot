package com.example.taskmanager;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public TaskEntity createTask(TaskRequest request) {
        TaskEntity task = new TaskEntity(
                request.title(),
                request.completed()
        );

        return taskRepository.save(task);
    }

    public Optional<TaskEntity> updateTask(
            Long id,
            TaskRequest request) {

        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(request.title());
                    existingTask.setCompleted(request.completed());

                    return taskRepository.save(existingTask);
                });
    }

    public boolean deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }

        taskRepository.deleteById(id);
        return true;
    }

    public List<TaskEntity> getIncompleteTasks() {
        return taskRepository.findByCompletedFalse();
    }

    public List<TaskEntity> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public List<TaskEntity> searchTasks(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public long countIncompleteTasks() {
        return taskRepository.countByCompletedFalse();
    }
}