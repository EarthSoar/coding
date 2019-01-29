package tx.dao;

/**
 * @author Willing
 * @date 2019/1/29
 */
public interface IAccountDAO {
    /**
     *  转出
     * @param id   转出方的id
     * @param money 转出金额
     */
    void transOut(Long id,Integer money);

    /**
     * 转入
     * @param id  接收方id
     * @param money   收到金额
     */
    void transIn(Long id,Integer money);
}
