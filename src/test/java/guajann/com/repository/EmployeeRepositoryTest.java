package guajann.com.repository;

import guajann.com.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee nuevo;

    @BeforeEach
    void setup(){
        nuevo = new Employee("Roberto","Programer");
    }

    @DisplayName("Test for save new employee")
    @Test
    void saveEmployee(){

        Employee nuevoGuardado = employeeRepository.save(nuevo);

        assertThat(nuevoGuardado).isNotNull();
        assertThat(nuevoGuardado.getId()).isNotNull();
        assertThat(nuevoGuardado.getId()).isNotEqualTo(0);
    }
    @DisplayName("Test for given employee for by Id")
    @Test
    void getFindById(){

        employeeRepository.save(nuevo);

        assertThat(employeeRepository.findById(1L)).isNotNull();

    }

    @DisplayName("Test for given all employes")
    @Test
    void getAllEmployee(){

        Employee nuevo1 = new Employee("Juakin","TL");
        employeeRepository.save(nuevo);
        employeeRepository.save(nuevo1);

        assertThat(employeeRepository.findAll().size()).isEqualTo(2);

    }

    @DisplayName("Test for update employee")
    @Test
    void getUpdateEmployee(){

        Employee nuevoSave = employeeRepository.save(nuevo);

        nuevoSave.setName("Juan");
        nuevoSave.setRole("TL");

        Employee nuevoUpdate = employeeRepository.save(nuevoSave);

        assertThat(nuevoUpdate.getName()).isEqualTo("Juan");
        assertThat(nuevoUpdate.getRole()).isEqualTo("TL");
    }


}