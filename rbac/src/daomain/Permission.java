package daomain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willing
 * @date 2019/2/16
 */

//权限对象
@Getter@Setter
public class Permission extends BaseDaomain {
    private String name;//权限名称
    private String expression;//权限表达式   如:service.EmployeeServiceImpl:delete
}
