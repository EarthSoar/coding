package query;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Willing
 * @date 2019/2/15
 */
public class EmployeeQueryObject {
    @Getter@Setter
    private String keyword;
    @Getter@Setter
    private Long deptId = -1L;

    @Getter@Setter
    private Integer pageSize = 3;
    @Getter@Setter
    private Integer currentPage = 1;

    private List<String> condition = new ArrayList<>();

    private List<Object> parameter = new ArrayList<>();

    //查询条件   (obj.name LIKE ? OR obj.email LIKE ?) AND obj.dept.id=?
    public String getQuery(){
        if(hasLength(keyword)){
            condition.add("(obj.name LIKE ? OR obj.email LIKE ?)");
            parameter.add("%" + keyword +"%");
            parameter.add("%" + keyword +"%");
        }
        if(deptId > 0){
            condition.add("obj.dept.id = ?");
            parameter.add(deptId);
        }
        StringBuilder sb = new StringBuilder(80);
        for (int i = 0; i < condition.size(); i++) {
            if(i == 0){
                sb.append(" WHERE ");
            }else{
                sb.append(" AND ");
            }
            sb.append(condition.get(i));
        }
        return sb.toString();
    }
    public List<Object> getParameters(){
        return this.parameter;
    }

    private Boolean hasLength(String str){
        return str != null && !str.equals(str.trim());
    }
}
