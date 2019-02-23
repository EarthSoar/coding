package ajax.linkage;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/23
 */
public class LinkageByJsonAction extends ActionSupport {


    private Long pid;

    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * [{id : 1,name : '四川'},{id : 2, name:'广东'},{id : 3, name : '陕西'}]
     */
    //加载所有省份
    public String execute() throws Exception {
        List<Province> ps = Province.getAllProvince();
        StringBuilder sb = new StringBuilder(80);
        sb.append("[");
        for (Province p : ps) {
            sb.append("{id : "+p.getId()+",name : '"+p.getName()+"'}").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(sb.toString());
        return NONE;
    }
    public String getCityByPid() throws Exception {
        List<City> cs = City.getCityByProvinceId(pid);
        StringBuilder sb = new StringBuilder(80);
        sb.append("[");
        for (City c : cs) {
            sb.append("{id : "+c.getId()+",name : '"+c.getName()+"'}").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(sb.toString());
        return NONE;
    }
}
