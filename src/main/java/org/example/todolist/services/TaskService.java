package org.example.todolist.services;
import org.example.todolist.entities.Task;

import java.util.Optional;

public interface TaskService {
    Task saveTask(Task task);
    Task updateTask(int id, String taskTitle);
    String deleteTask(int id);
    Optional<Task> getTask(int id);
}
