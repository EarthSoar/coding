package ajax;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Willing
 * @date 2019/2/22
 */
public class AjaxLoginAction extends ActionSupport{

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(username + "--" + password);
        return NONE;
    }
}
