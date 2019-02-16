package web.action;

import com.opensymphony.xwork2.ActionContext;
import daomain.Employee;
import lombok.Getter;
import lombok.Setter;
import query.EmployeeQueryObject;
import service.IDepartmentService;
import service.IEmployeeService;
import util.RequiredPermission;

/**
 * @author Willing
 * @date 2019/2/14
 */
public class EmployeeAction extends BaseAction{

    @Setter
    private IEmployeeService employeeService;

    @Setter
    private IDepartmentService departmentService;

    @Getter
    private Employee employee = new Employee();

    @Getter
    @Setter
    private EmployeeQueryObject qo = new EmployeeQueryObject();

    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("employees",employeeService.query(qo));
        ActionContext.getContext().put("depts",departmentService.list());
        return LIST;
    }

    @RequiredPermission("员工录入")
    public String input(){
        ActionContext.getContext().put("depts",departmentService.list());
        //回显数据
        if(employee.getId() != null){
            employee = employeeService.get(employee.getId());
        }
        return INPUT;
}

    public String saveOrUpdate(){
        if(employee.getId() == null){//保存操作
            employeeService.save(employee);
        }else {
            employeeService.update(employee);
        }
        return SUCCESS;
    }
    public String delete(){
        employeeService.delete(employee.getId());
        return SUCCESS;
    }

    @Override//在所有的action之前都会执行
    public void prepare() throws Exception {
    }
    //只会在saveOrUpdate之前执行
    public void prepareSaveOrUpdate() throws Exception {
        //解决编辑员工丢失密码的问题
        //参数拦截器在Prepared之后执行,所有让参数拦截器在prepared之前执行,修改默认的defaultStack为paramsPrepareParamsStack
        if(employee.getId() != null){
            employee = employeeService.get(employee.getId());
        }
    }
}
