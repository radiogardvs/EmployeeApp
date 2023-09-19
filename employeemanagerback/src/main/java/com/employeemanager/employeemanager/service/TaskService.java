package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dao.Task;
import com.employeemanager.employeemanager.dto.TaskDTO;
import com.employeemanager.employeemanager.mapper.TaskMapper;
import com.employeemanager.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        return TaskMapper.toDTO(taskRepository.save(task));
    }

    public List<TaskDTO> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        return TaskMapper.toDTO(taskRepository.save(task));
    }

    public TaskDTO findTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow();
        return TaskMapper.toDTO(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
