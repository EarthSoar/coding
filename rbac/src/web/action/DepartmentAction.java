package web.action;

import com.opensymphony.xwork2.ActionContext;
import daomain.Department;
import lombok.Getter;
import lombok.Setter;
import service.IDepartmentService;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/12
 */
public class DepartmentAction extends BaseAction{
    @Setter
    private IDepartmentService departmentService;

    @Getter
    private Department department = new Department();

    @Override
    public String execute(                                                                                                                                                ) throws Exception {
        List<Department> departmentList = departmentService.list();
        ActionContext.getContext().put("departments",departmentList);
        return LIST;
    }

    public String input(){
        if (department.getId() != null){
            department = departmentService.get(department.getId());
        }
        return INPUT;
    }

    public String saveOrUpdate(){
        if(department.getId() == null){
            departmentService.save(department);
        }else{
            departmentService.update(department);
        }
        return SUCCESS;
    }

    public String delete(){
        departmentService.delete(department.getId());
        return SUCCESS;
    }

}
