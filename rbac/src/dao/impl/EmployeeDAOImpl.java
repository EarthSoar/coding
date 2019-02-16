package dao.impl;

import dao.IEmployeeDAO;
import daomain.Employee;
import org.hibernate.Query;
import query.EmployeeQueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {
    @Override
    public List<Employee> query(EmployeeQueryObject qo) {

        String hql = "SELECT obj FROM Employee obj" + qo.getQuery();
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        System.out.println(hql);
        for (int i = 0; i < qo.getParameters().size(); i++) {
            query.setParameter(i,qo.getParameters().get(i));
        }
        return query.list();

   /*     //查询结果总数
        String countHql = "SELECT COUNT(obj) FROM Employee obj" + qo.getQuery();
        Query query = sessionFactory.getCurrentSession().createQuery(countHql);
        setParameter(qo,query);//设置占位符参数

        //查询结果集
        String resultHql = "SELECT obj FROM Employee obj " + qo.getQuery() + " LIMIT ?,? ";
        query = sessionFactory.getCurrentSession().createQuery(resultHql);
        setParameter(qo,query);

        qo.getParameters().add((qo.getCurrentPage() - 1) * qo.getPageSize());
        qo.getParameters().add(qo.getPageSize());

        List<Employee> listData = query.list();*/

    }

    private void setParameter(EmployeeQueryObject qo,Query query){
        for (int i = 0; i < qo.getParameters().size(); i++) {
            query.setParameter(i,qo.getParameters().get(i));
        }
    }
}
