package com.fabiomaciel.todo.domain.service;

import com.fabiomaciel.todo.infra.db.models.Task;
import com.fabiomaciel.todo.infra.db.repository.TaskRepository;
import com.fabiomaciel.todo.infra.web.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById( Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask( Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
    }

    public Task toggleTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask( Long id) {
        taskRepository.deleteById(id);
    }
}
