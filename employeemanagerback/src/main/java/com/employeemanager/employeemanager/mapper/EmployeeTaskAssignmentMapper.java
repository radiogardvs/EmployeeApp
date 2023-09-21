package com.employeemanager.employeemanager.mapper;
import com.employeemanager.employeemanager.dao.EmployeeTaskAssignment;
import com.employeemanager.employeemanager.dto.EmployeeTaskAssignmentDTO;
import com.employeemanager.employeemanager.repository.EmployeeTaskAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTaskAssignmentMapper {
    private final EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository;
    @Autowired
    public EmployeeTaskAssignmentMapper(EmployeeTaskAssignmentRepository employeeTaskAssignmentRepository){
        this.employeeTaskAssignmentRepository=employeeTaskAssignmentRepository;
    }
    public EmployeeTaskAssignmentDTO toDTO(EmployeeTaskAssignment assignment) {
        EmployeeTaskAssignmentDTO assignmentDTO = new EmployeeTaskAssignmentDTO();
        assignmentDTO.setId(assignment.getId());
        assignmentDTO.setEmployeeId(assignment.getEmployee().getId());
        assignmentDTO.setTaskId(assignment.getTask().getId());
        return assignmentDTO;
    }

    public EmployeeTaskAssignment toEntity(EmployeeTaskAssignmentDTO assignmentDTO) {
        return employeeTaskAssignmentRepository.findById(assignmentDTO.getId()).orElseThrow();
    }
}