package service;

import daomain.Role;
import query.QueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
//角色的业务接口
public interface IRoleService {
    void save(Role e);
    void delete(Long id);
    void update(Role e);
    Role get(Long id);
    List<Role> list();
    List query(QueryObject qo);
}
