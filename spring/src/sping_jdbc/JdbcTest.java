package sping_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sping_jdbc.domain.Employee;
import sping_jdbc.service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JdbcTest {

    @Autowired
    private IEmployeeService service;
    @Test
    public void testSave(){
        Employee employee = new Employee();
        employee.setName("小xiao ");
        employee.setAge(11);
        service.save(employee);
    }
    @Test
    public void testGet(){
        Employee e = service.get(1L);
        System.out.println(e);
    }

    @Test
    public void testList(){
        List<Employee> list = service.list();
        for (Employee e:list
             ) {
            System.out.println(e);
        }
    }
}
