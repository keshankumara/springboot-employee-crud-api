package com.ruhuna.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET all employees
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    //  POST new employee
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee addEmployee) {
        Employee saved = employeeRepository.save(addEmployee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //  GET employee by ID
    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<?> findEmployee(@PathVariable int id) {
        if (id < 0) {
            return ResponseEntity.badRequest().body("ID cannot be less than zero");
        }

        /*
        // short form bellow code

        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found"));

         */

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            Employee foundEmployee = employee.get();
            ResponseEntity<Employee> response = ResponseEntity.ok(foundEmployee);
            return response;
        } else {
            ResponseEntity<String> notFoundResponse = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
            return notFoundResponse;
        }

    }


    //  PUT update employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee updateData) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updateData.getFirstName());
            employee.setLastName(updateData.getLastName());
            employee.setEmail(updateData.getEmail());
            employeeRepository.save(employee);
            return ResponseEntity.ok("Employee updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    //  DELETE employee by ID
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee removed successfully");
    }
}
