package win.ddd.response.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import win.ddd.response.entity.Employee;
import win.ddd.response.response.ApiResponse;
import win.ddd.response.service.EmployeeService;
import win.ddd.response.util.ResponseUtil;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable Integer id,
                                                                @RequestBody Employee employee,
                                                                HttpServletRequest request) {
        Employee emp = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(ResponseUtil.success(emp, "Employee updated", request.getRequestURI()));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@RequestBody Employee employee, HttpServletRequest request) {
        Employee emp = employeeService.createEmployee(employee);
        return ResponseEntity.ok(ResponseUtil.success(emp, "Employee created",request.getRequestURI()));
    }
}
