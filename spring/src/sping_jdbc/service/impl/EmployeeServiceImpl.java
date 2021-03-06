package sping_jdbc.service.impl;

import lombok.Setter;
import sping_jdbc.dao.IEmployeeDAO;
import sping_jdbc.domain.Employee;
import sping_jdbc.service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/28
 */
public class EmployeeServiceImpl implements IEmployeeService {

    @Setter
    private IEmployeeDAO employeeDAO;

    @Override
    public void save(Employee e) {
        employeeDAO.save(e);
    }

    @Override
    public void delete(Employee e) {
        employeeDAO.delete(e);
    }

    @Override
    public void update(Employee e) {
        employeeDAO.update(e);
    }

    @Override
    public Employee get(Long id) {
        return employeeDAO.get(id);
    }

    @Override
    public List<Employee> list() {
        return employeeDAO.list();
    }
}
