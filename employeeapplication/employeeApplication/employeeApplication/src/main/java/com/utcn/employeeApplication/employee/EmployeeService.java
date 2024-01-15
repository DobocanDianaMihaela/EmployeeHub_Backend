package com.utcn.employeeApplication.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Transactional
    public Employee updateEmployee(Integer employeeID, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeID);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();

            if (updatedEmployee.getName() != null) {
                employee.setName(updatedEmployee.getName());
            }

            if (updatedEmployee.getDepartmentID() != null) {
                employee.setDepartmentID(updatedEmployee.getDepartmentID());
            }


            if (updatedEmployee.getManagerID() != null) {
                employee.setManagerID(updatedEmployee.getManagerID());
            }

            if (updatedEmployee.getEmail() != null) {
                employee.setEmail(updatedEmployee.getEmail());
            }

            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getAllEmployeesPerDepartment(Integer departmentID) {
        return employeeRepository.findByDepartmentID(departmentID);
    }

    public List<Employee> getAllManagersPerDepartment(Integer departmentID) {
        return employeeRepository.findEmployeesByDepartmentIDAndManagerIDNot(departmentID,0);
    }
}
