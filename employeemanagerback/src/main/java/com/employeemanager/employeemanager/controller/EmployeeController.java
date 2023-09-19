package com.employeemanager.employeemanager.controller;

import com.employeemanager.employeemanager.dao.*;
import com.employeemanager.employeemanager.dto.EmployeeDTO;
import com.employeemanager.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employeeDTOs = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(id);
        if (employeeDTO != null) {
            return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployeeDTO = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(newEmployeeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(updatedEmployeeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
