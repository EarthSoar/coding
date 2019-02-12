package service.impl;

import dao.IEmployeeDAO;
import daomain.Employee;
import service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Override
    public void save(Employee e) {
        employeeDAO.save(e);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
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
