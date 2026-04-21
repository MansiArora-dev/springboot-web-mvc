package com.springbootweb.services;

import com.springbootweb.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeDTO> getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee);

    EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO);

    boolean deleteEmployeeById(Long employeeId);

    EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates);

}