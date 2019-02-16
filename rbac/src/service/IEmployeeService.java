package service;

import daomain.Employee;
import query.EmployeeQueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public interface IEmployeeService {
    void save(Employee e);
    void delete(Long id);
    void update(Employee e);
    Employee get(Long id);
    List<Employee> list();

    List<Employee> query(EmployeeQueryObject qo);
}
