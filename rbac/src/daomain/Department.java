package daomain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willing
 * @date 2019/2/11
 */
@Getter@Setter
public class Department extends BaseDaomain{
    private String name;//部门名称
    private String sn;//部门编号
}
