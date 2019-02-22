package ajax;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/22
 */
public class CheckNameAction extends ActionSupport {

    List<String> data = Arrays.asList("hello","willing","giao");

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception {
        String msg = "恭喜你,此用户名可以注册";
        if(data.contains(username)){
            msg = "该用户名已被注册，请换一个";
        }
        //设置响应的编码
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");

        ServletActionContext.getResponse().getWriter().println(msg);
        return NONE;
    }
}
