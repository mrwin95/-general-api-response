package win.ddd.response.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import win.ddd.response.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
