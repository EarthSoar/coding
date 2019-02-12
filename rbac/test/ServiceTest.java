import daomain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IDepartmentService;

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
}
