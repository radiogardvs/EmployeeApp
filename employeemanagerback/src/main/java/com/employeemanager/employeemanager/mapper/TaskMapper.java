package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Task;
import com.employeemanager.employeemanager.dto.TaskDTO;

public class TaskMapper {
    public static TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setEstimatedTime(task.getEstimatedTime());
        taskDTO.setEffectiveTime(task.getEffectiveTime());
        return taskDTO;
    }

    public static Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEstimatedTime(taskDTO.getEstimatedTime());
        task.setEffectiveTime(taskDTO.getEffectiveTime());
        return task;
    }
}
