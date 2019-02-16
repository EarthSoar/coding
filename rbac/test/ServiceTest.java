import daomain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import query.EmployeeQueryObject;
import service.IDepartmentService;
import service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void testSaveDept(){
        Department d = new Department();
        d.setName("asd");
        d.setSn("A");
        departmentService.save(d);
    }
    @Test
    public void testList(){
        List<Department> list = departmentService.list();
        for (Department department : list) {
            System.out.println(department);
        }
    }
    @Test
    public void testGet(){
        System.out.println(departmentService.get(1L));
    }

    @Test
    public void testQuery(){
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword("小");
    }
}
