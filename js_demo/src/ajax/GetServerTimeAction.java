package ajax;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * @author Willing
 * @date 2019/2/22
 */
public class GetServerTimeAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ServletActionContext.getResponse().getWriter().println(new java.util.Date().toLocaleString());
        return NONE;
    }
}
