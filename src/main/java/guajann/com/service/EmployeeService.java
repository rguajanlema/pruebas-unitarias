package guajann.com.service;

import guajann.com.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
    Employee save(Employee employee);
    Employee findById(Long id);
    boolean deleteById(Long id);
}
