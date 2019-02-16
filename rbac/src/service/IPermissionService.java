package service;

import daomain.Role;
import query.QueryObject;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
//权限的业务接口
public interface IPermissionService {
    void delete(Long id);
    List<Role> list();
    List query(QueryObject qo);
    void reload();//加载权限
}
