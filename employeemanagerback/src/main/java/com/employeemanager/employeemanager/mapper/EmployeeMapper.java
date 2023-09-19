package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Employee;
import com.employeemanager.employeemanager.dto.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setImageUrl(employee.getImageUrl());
        employeeDTO.setEmployeeCode(employee.getEmployeeCode());
        return employeeDTO;
    }

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setPhone(employeeDTO.getPhone());
        employee.setImageUrl(employeeDTO.getImageUrl());
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        return employee;
    }
}
