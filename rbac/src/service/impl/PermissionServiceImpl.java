package service.impl;

import dao.IPermissionDAO;
import daomain.Permission;
import daomain.Role;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import query.QueryObject;
import service.IPermissionService;
import util.PermissionUtil;
import util.RequiredPermission;
import web.action.BaseAction;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Willing
 * @date 2019/2/16
 */
public class PermissionServiceImpl implements IPermissionService,ApplicationContextAware {

    @Setter
    private IPermissionDAO permissionDAO;

    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
    @Setter
    private IPermissionService permissionService;

    @Override
    public void delete(Long id) {
        permissionService.delete(id);
    }

    @Override
    public List<Role> list() {
        return permissionService.list();
    }

    @Override
    public List query(QueryObject qo) {
        return permissionService.query(qo);
    }

    @Override
    //加载权限
    public void reload() {
        //查询出数据库所有的权限表达式
        List<Permission> ps = permissionDAO.list();
        Set<String> expression = new HashSet<>();
        for (Permission p : ps) {
            expression.add(p.getExpression());
        }
        //扫描BaseAction的所有子类,在applicationContext.xml配置的action
        Map<String, BaseAction> beansOfType = ctx.getBeansOfType(BaseAction.class);
        Collection<BaseAction> actions = beansOfType.values();
        for (BaseAction action : actions) {
            //迭代出每一个action中的所有方法
            Method[] methods = action.getClass().getDeclaredMethods();
            for (Method method : methods) {
                //判断当前方法上是否有requiredPermission标签
                RequiredPermission rp = method.getAnnotation(RequiredPermission.class);
                String exp = PermissionUtil.buildeExpression(method);
                if(!expression.contains(exp)) {
                    if (rp != null) {//存在标签
                        String name = rp.value();
                        Permission permission = new Permission();
                        permission.setName(name);
                        permission.setExpression(exp);
                        permissionDAO.save(permission);
                    }
                }
            }
        }
    }
}
