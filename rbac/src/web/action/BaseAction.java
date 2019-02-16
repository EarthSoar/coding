package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author Willing
 * @date 2019/2/15
 */
public class BaseAction extends ActionSupport implements Preparable {

    //列表逻辑视图
    protected static final String LIST = "list";


    @Override
    //在所有action之前执行
    public void prepare() throws Exception {
    }
}
