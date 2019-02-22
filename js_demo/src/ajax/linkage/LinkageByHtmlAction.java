package ajax.linkage;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/22
 */
public class LinkageByHtmlAction extends ActionSupport {

    private Long pid;
    public void setPid(Long pid) {
        this.pid = pid;
    }
    @Override
    public String execute() throws Exception {
        List<Province> ps = Province.getAllProvince();
        // <option value='1'>1</option>
        StringBuilder sb = new StringBuilder(80);
        for (Province p : ps) {
            sb.append("<option value='"+p.getId()+"'>"+p.getName()+"</option>");
        }
        //设置输出格式和编码格式
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(sb.toString());
        return NONE;
    }

    public String getCityById() throws Exception {
        List<City> cs = City.getCityByProvinceId(pid);
        StringBuilder sb = new StringBuilder(80);
        for (City c : cs) {
            sb.append("<option value='"+c.getId()+"'>"+c.getName()+"</option>");
        }
        //设置输出格式和编码格式
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(sb.toString());
        return NONE;
    }

}
