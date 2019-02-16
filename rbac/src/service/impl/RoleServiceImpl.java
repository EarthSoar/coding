package service.impl;

import dao.IRoleDAO;
import daomain.Role;
import lombok.Setter;
import query.QueryObject;
import service.IRoleService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
public class RoleServiceImpl implements IRoleService {

    @Setter
    private IRoleDAO roleDAO;

    @Override
    public void save(Role e) {
        roleDAO.save(e);
    }

    @Override
    public void delete(Long id) {
        roleDAO.delete(id);
    }

    @Override
    public void update(Role e) {
        roleDAO.update(e);
    }

    @Override
    public Role get(Long id) {
        return roleDAO.get(id);
    }

    @Override
    public List<Role> list() {
        return roleDAO.list();
    }

    @Override
    public List query(QueryObject qo) {
        return null;
    }
}
