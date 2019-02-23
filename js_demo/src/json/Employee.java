package json;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Willing
 * @date 2019/2/23
 */
@Getter@Setter
public class Employee implements IJsonObject{
    private Long id;
    private String username;
    private String password;//不需要转化为JSON字符串
    private String email;

    public Employee(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //把一部分部分属性转为为JSON字符串
    public Object toJson() {
        Map<String,Object> jsonMap = new HashMap<>();//key: 需要转化为的属性名称,value： 属性值
        jsonMap.put("id",id);
        jsonMap.put("name",username);
        jsonMap.put("email",email);
        return jsonMap;
    }

    //test
    public static void main(String[] args) {
        Employee employee = new Employee(1L,"willing","21","123@qq.com");
        String jsonStr = JSON.toJSONString(employee.toJson());
        System.out.println(jsonStr);
    }
}

