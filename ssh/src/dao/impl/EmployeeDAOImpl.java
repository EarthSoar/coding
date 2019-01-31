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
        Session session = sessionFactory.getCurrentSession();
        session.delete(e);
    }

    @Override
    public void update(Employee e) {
        Session session = sessionFactory.getCurrentSession();
        session.update(e);
    }

    @Override
    public Employee get(Long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class,id);
    }

    @Override
    public List<Employee> list() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT e FROM Employee e";
        List<Employee> list = session.createQuery(hql).list();
        return list;
    }
}
