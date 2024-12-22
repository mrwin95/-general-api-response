package win.ddd.response.service;

import org.springframework.stereotype.Service;
import win.ddd.response.entity.Employee;
import win.ddd.response.exception.ResourceNotFoundException;
import win.ddd.response.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employeeToUpdate = employeeOptional.get();
            employeeToUpdate.setName(employee.getName());
            employeeToUpdate.setDepartment(employee.getDepartment());
            return employeeRepository.save(employeeToUpdate);
        }else {
            throw new ResourceNotFoundException("Employee not found" + id);
        }
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
