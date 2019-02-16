package daomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/11
 */
@Getter@Setter@ToString
public class Employee extends BaseDaomain {
    private String name; //员工名称
    private String password;//员工密码
    private Integer age;
    private String email;
    private Boolean admin;//是否为超级管理员
    private Department dept;//所属部门

    //一个用户有多个角色，一个角色也可以赋给多个用户,many2many
    private List<Role> roles = new ArrayList<>();
}
