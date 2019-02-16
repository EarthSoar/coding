package dao.impl;

import dao.IGenericDAO;
import lombok.Setter;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/15
 */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

    @Setter
    protected SessionFactory sessionFactory;


    private Class<T> targetType;//泛型字节码类型

    //获取daomain的字节码对象
    public GenericDAOImpl(){
        //得到DAO实现类带有泛型的父类
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        //得到真实的参数类型
        targetType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(get(id));
    }

    @Override
    public void update(T obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public T get(Long id) {
        return (T) sessionFactory.getCurrentSession().get(targetType,id);
    }

    @Override
    public List<T> list() {
        return sessionFactory.getCurrentSession().createCriteria(targetType).list();
    }
}
