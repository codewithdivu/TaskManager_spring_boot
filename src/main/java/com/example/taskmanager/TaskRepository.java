package com.example.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository
        extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByCompletedFalse();

    List<TaskEntity> findByCompleted(boolean completed);

    List<TaskEntity> findByTitleContainingIgnoreCase(String title);

    long countByCompletedFalse();
}