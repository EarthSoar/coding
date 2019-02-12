package daomain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willing
 * @date 2019/2/11
 */
@Getter@Setter
public class Employee {
    private Long id;
    private String name;
    private String password;
    private Integer age;
}
