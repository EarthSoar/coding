package service;

import daomain.Department;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public interface IDepartmentService {
    void save(Department d);
    void delete(Long id);
    void update(Department d);
    Department get(Long id);
    List<Department> list();
}
