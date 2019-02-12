package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import daomain.Department;
import lombok.Setter;
import service.IDepartmentService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/12
 */
public class DepartmentAction extends ActionSupport{
    @Setter
    private IDepartmentService departmentService;

    @Override
    public String execute(                                                                                                                                                ) throws Exception {
        List<Department> departmentList = departmentService.list();
        ActionContext.getContext().put("departments",departmentList);
        return "list";
    }

    public String inputDept(){
        return INPUT;
    }

    public String saveDept(){

        return SUCCESS;
    }
}
