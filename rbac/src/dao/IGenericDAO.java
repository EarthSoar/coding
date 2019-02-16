package dao;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/15
 */
public interface IGenericDAO<T> {
    void save(T obj);
    void delete(Long id);
    void update(T obj);
    T get(Long id);
    List<T> list();
}
