package com.example.taskmanager;

public record Task(
        Long id,
        String title,
        Boolean completed
){}
