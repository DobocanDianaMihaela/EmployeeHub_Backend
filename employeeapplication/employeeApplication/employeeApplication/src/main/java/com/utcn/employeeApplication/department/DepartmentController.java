package com.utcn.employeeApplication.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    //create
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.create(department);
    }

    //read
    @GetMapping("/{departmentID}")
    public Department getDepartment(@PathVariable Integer departmentID) {
        return departmentService.getDepartmentById(departmentID);
    }

    //update
    @PutMapping("/{departmentID}")
    public Department updateDepartment(@PathVariable Integer departmentID, @RequestBody Department updatedDepartment) {

        return departmentService.updateDepartment(departmentID, updatedDepartment);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/byParentID")
    public List<Department> getDepartmentsByParentID(@RequestParam("parentID") Integer parentID) {
        return departmentService.getDepartmentsByParentID(parentID);
    }

}
