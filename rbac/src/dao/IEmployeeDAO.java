package dao;

import daomain.Employee;
import query.EmployeeQueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public interface IEmployeeDAO extends IGenericDAO<Employee> {
    List<Employee> query(EmployeeQueryObject qo);
}
