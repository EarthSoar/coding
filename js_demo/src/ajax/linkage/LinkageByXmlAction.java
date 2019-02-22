package ajax.linkage;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/22
 */
public class LinkageByXmlAction extends ActionSupport {

    private Long pid;
    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String execute() throws Exception {
        List<Province> ps = Province.getAllProvince();

        //新建一个XML文档
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        //创建根元素
        Element root = doc.createElement("datas");
        //把根元素添加到文档中
        doc.appendChild(root);
        for (Province p : ps) {
            //创建子元素
            Element dataEl = doc.createElement("data");
            //给元素添加文本内容和id属性
            dataEl.setAttribute("id",p.getId().toString());
            dataEl.setTextContent(p.getName());
            //把子元素添加到根元素下面
            root.appendChild(dataEl);
        }
        ServletActionContext.getResponse().setContentType("text/xml;charset=utf-8");
        //同步转换器
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        //把xml文档对象输出到响应流中
        trans.transform(new DOMSource(doc),new StreamResult(ServletActionContext.getResponse().getOutputStream()));
        return NONE;
    }

    public String getCityByPid() throws Exception {
        List<City> cs = City.getCityByProvinceId(pid);
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("datas");
        doc.appendChild(root);
        for (City c : cs) {
            Element dataEl = doc.createElement("data");
            dataEl.setAttribute("id",c.getId().toString());
            dataEl.setTextContent(c.getName());
            root.appendChild(dataEl);
        }
        ServletActionContext.getResponse().setContentType("text/xml;charset=utf-8");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc),new StreamResult(ServletActionContext.getResponse().getOutputStream()));
        return NONE;
    }
}
