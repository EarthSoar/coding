package test;

import daomain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService service;

    @Test
    public void testSave(){
        Employee e = new Employee();
        e.setName("Ss");
        e.setAge(10);
        service.save(e);
    }
    @Test
    public void testList(){
        List<Employee> list = service.list();
        for (Employee e:
             list) {
            System.out.println(e);
        }
    }
}
