package sping_jdbc.service;

import sping_jdbc.domain.Employee;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/28
 */
public interface IEmployeeService {
    void save(Employee e);
    void delete(Employee e);
    void update(Employee e);
    Employee get(Long id);
    List<Employee> list();
}
