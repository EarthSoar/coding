package daomain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/16
 */

//角色对象
@Getter
@Setter
public class Role extends BaseDaomain{
    private String name;//角色名称
    private String sn;//角色代码

    //一个角色有多个权限,一个权限也可以赋给多个角色
    private List<Permission> permissions = new ArrayList<>();
}
