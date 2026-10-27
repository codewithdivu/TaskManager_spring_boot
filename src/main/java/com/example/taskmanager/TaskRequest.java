package com.example.taskmanager;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequest(
        @NotBlank(message = "Task title is required")
        @Size(max = 100, message = "Task title must be at most 100 characters.")
        String title,

        boolean completed
){ }