package query;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Willing
 * @date 2019/2/15
 */
@Setter@Getter
public class PageResult {
    private List<?> listData;  //结果集 ： 通过SQL语句查询出来的
    private Integer totalCount;//数据总数: 通过SQL查询出来

    private Integer currentPage; //当前页 .用户传入的
    private Integer pageSize; //每页显示多少数据,用户传入

    private Integer beginPage = 1;//首页
    private Integer prevPage;//上一页  :需要计算
    private Integer nextPage;//下一页 ：需要计算
    private Integer totalPage;//总页数/末页   :需要计算


    //通过构造器给页面结果对象设置值
    public PageResult(List<?> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        prevPage = currentPage >= 2 ? currentPage - 1 : 1;
        nextPage = currentPage <= totalPage - 1 ? currentPage + 1 : totalPage;
    }

}
