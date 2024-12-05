package org.example.todolist.services.impl;


import org.example.todolist.entities.Task;
import org.example.todolist.repositories.TaskRepository;
import org.example.todolist.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(int id, String taskTitle) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskTitle);
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    @Override
    public String deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
        return "Task Deleted";
    }
    @Override
    public Optional<Task> getTask(int id) {
        return taskRepository.findById(id);
    }
}
