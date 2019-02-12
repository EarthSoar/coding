package dao;

import daomain.Employee;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public interface IEmployeeDAO {
    void save(Employee e);
    void delete(Long id);
    void update(Employee e);
    Employee get(Long id);
    List<Employee> list();
}
