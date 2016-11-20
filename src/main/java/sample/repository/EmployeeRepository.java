package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Employee;

/**
 * Created by marek on 10.11.16.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
