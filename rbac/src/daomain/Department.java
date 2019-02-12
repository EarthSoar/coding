package daomain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Willing
 * @date 2019/2/11
 */
@Getter@Setter@ToString
public class Department {
    private Long id;//主键
    private String name;//部门名称
    private String sn;//部门编号
}
