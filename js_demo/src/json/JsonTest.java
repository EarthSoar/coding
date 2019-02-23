package json;

import ajax.linkage.Province;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONSerializer;
import org.junit.Test;

/**
 * @author Willing
 * @date 2019/2/23
 */
public class JsonTest {

    /**
     * JSON格式化工具
     *      1.json-lib  :   JSONSerializer类
     *      2.fastjson  :   JSON类
     */
    @Test
    public void testJsonLib(){
        Province p = Province.getAllProvince().get(0);
        //转化一个对象
        String one = JSONSerializer.toJSON(p).toString();
        System.out.println(one);
        //转化对象的集合
        String set = JSONSerializer.toJSON(Province.getAllProvince()).toString();
        System.out.println(set);
    }

    @Test
    public void testFast(){
        String one = JSON.toJSONString(Province.getAllProvince().get(0));
        System.out.println(one);
        String set = JSON.toJSONString(Province.getAllProvince());
        System.out.println(set);
    }
}
