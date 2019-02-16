package service.impl;

import dao.IEmployeeDAO;
import daomain.Employee;
import lombok.Setter;
import query.EmployeeQueryObject;
import service.IEmployeeService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class EmployeeServiceImpl implements IEmployeeService {

    @Setter
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

    @Override
    public List<Employee> query(EmployeeQueryObject qo) {
        return employeeDAO.query(qo);
    }
}
