package web.action;

import com.opensymphony.xwork2.ActionContext;
import lombok.Setter;
import service.IRoleService;

/**
 * @author Willing
 * @date 2019/2/14
 */
public class RoleAction extends BaseAction{

    @Setter
    private IRoleService roleService;

    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("roles",roleService.list());
        return LIST;
    }

    public String input(){
        return INPUT;
}

    public String saveOrUpdate(){
        return SUCCESS;
    }
    public String delete(){
        return SUCCESS;
    }

    @Override//在所有的action之前都会执行
    public void prepare() throws Exception {
    }
}
