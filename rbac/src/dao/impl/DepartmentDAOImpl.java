package dao.impl;

import dao.IDepartmentDAO;
import daomain.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class DepartmentDAOImpl implements IDepartmentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFacory){
        this.sessionFactory = sessionFacory;
    }

    @Override
    public void save(Department e) {
        sessionFactory.getCurrentSession().save(e);
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(get(id));
    }

    @Override
    public void update(Department e) {
        sessionFactory.getCurrentSession().update(e);
    }

    @Override
    public Department get(Long id) {
        return (Department) sessionFactory.getCurrentSession().get(Department.class,id);
    }

    @Override
    public List<Department> list() {
        return sessionFactory.getCurrentSession().createQuery("SELECT d FROM Department d").list();
    }
}
