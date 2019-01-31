package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import service.IEmployeeService;

/**
 * @author Willing
 * @date 2019/1/29
 */
public class EmployeeAction extends ActionSupport{

    @Setter
    private IEmployeeService employeeService;
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("employees",employeeService.list());
        return "list";
    }
}
