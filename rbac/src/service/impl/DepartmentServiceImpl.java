package service.impl;

import dao.IDepartmentDAO;
import daomain.Department;
import lombok.Setter;
import service.IDepartmentService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class DepartmentServiceImpl implements IDepartmentService {

    @Setter
    private IDepartmentDAO departmentDAO;
    @Override
    public void save(Department d) {
        departmentDAO.save(d);
    }

    @Override
    public void delete(Long id) {
        departmentDAO.delete(id);
    }

    @Override
    public void update(Department d) {
        departmentDAO.update(d);
    }

    @Override
    public Department get(Long id) {
        return departmentDAO.get(id);
    }

    @Override
    public List<Department> list() {
        return departmentDAO.list();
    }
}
