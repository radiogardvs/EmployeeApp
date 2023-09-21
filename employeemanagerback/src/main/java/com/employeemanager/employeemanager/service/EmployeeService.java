package com.employeemanager.employeemanager.service;
import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.mapper.EmployeeMapper;
import com.employeemanager.employeemanager.mapper.EmployeeTaskAssignmentMapper;
import com.employeemanager.employeemanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeTaskAssignmentMapper employeeTaskAssignmentMapper;
    private final EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, EmployeeTaskAssignmentMapper employeeTaskAssignmentMapper,
                           EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.employeeTaskAssignmentMapper = employeeTaskAssignmentMapper;
        this.employeeTaskAssignmentRepository=employeeTaskAssignmentRepository;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.updateEntity(employeeDTO)));
    }

    public EmployeeDTO findEmployeeById(Long id) {
        return employeeMapper.toDTO(employeeRepository.findById(id).orElseThrow());//todo exception
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeTaskAssignmentDTO assignTask(EmployeeTaskAssignmentDTO employeeTaskAssignmentDTO){
        return employeeTaskAssignmentMapper.toDTO(employeeTaskAssignmentRepository.save(employeeTaskAssignmentMapper.toEntity(employeeTaskAssignmentDTO)));
    }

}