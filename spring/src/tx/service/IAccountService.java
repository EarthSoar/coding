package tx.service;

/**
 * @author Willing
 * @date 2019/1/29
 */
public interface IAccountService {
    /**
     * 转账
     * @param outId 转出id
     * @param inId  转入id
     * @param money 交易金额
     */
    void trans(Long outId,Long inId,Integer money);
}
