package com.utcn.employeeApplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // create
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    // read
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    //update
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/byName")
    public List<Employee> getEmployeesByName(@RequestParam("name") String name) {
        return employeeService.getEmployeesByName(name);
    }
    @GetMapping("/employeesByDepartment")
    public List<Employee> getAllEmployeesPerDepartment(@RequestParam Integer departmentID) {
        return employeeService.getAllEmployeesPerDepartment(departmentID);
    }

    @GetMapping("/managersByDepartment")
    public List<Employee> getAllManagersPerDepartment(@RequestParam Integer departmentID) {
        return employeeService.getAllManagersPerDepartment(departmentID);
    }
}
