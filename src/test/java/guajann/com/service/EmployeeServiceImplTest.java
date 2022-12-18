package guajann.com.service;

import guajann.com.entity.Employee;
import guajann.com.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    private Employee employee;

    @BeforeEach
    void setup() {
        //this.employeeService = new EmployeeServiceImpl(this.employeeRepository);
        employee = new Employee("Roberto", "TL");
    }

    @DisplayName("Test show all employees")
    @Test
    void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeesList() {
        Employee employee1 = new Employee("Tony", "TL");

        given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));
        List<Employee> employeeList = employeeService.getAll();

        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }


}