package dao.impl;

import dao.IEmployeeDAO;
import daomain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Willing
 * @date 2019/1/28
 */
public class EmployeeDAOImpl implements IEmployeeDAO {


    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.save(e);
    }

    @Override
    public void delete(Employee e) {

    }

    @Override
    public void update(Employee e) {

    }

    @Override
    public Employee get(Long id) {
        return null;
    }

    @Override
    public List<Employee> list() {
        return null;
    }
}
