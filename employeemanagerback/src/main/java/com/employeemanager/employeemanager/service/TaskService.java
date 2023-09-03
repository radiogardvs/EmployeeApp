package com.employeemanager.employeemanager.service;
import com.employeemanager.employeemanager.exception.TaskNotFoundException;
import com.employeemanager.employeemanager.model.Task;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id){
        return taskRepository.findTaskById(id).orElseThrow(()-> new TaskNotFoundException("Task with id"+id+"was not found"));
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
