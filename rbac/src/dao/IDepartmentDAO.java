package dao;

import daomain.Department;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public interface IDepartmentDAO {
    void save(Department e);
    void delete(Long id);
    void update(Department e);
    Department get(Long id);
    List list();
}
