package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.exception.EmployeeNotFoundException;
import com.employeemanager.employeemanager.dao.Employee;
import com.employeemanager.employeemanager.mapper.EmployeeMapper;
import com.employeemanager.employeemanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        employee.setEmployeeCode(UUID.randomUUID().toString());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }

    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(updatedEmployee);
    }

    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " was not found"));
        return EmployeeMapper.toDTO(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}