package tx.service.impl;

import lombok.Setter;
import tx.dao.IAccountDAO;
import tx.service.IAccountService;

/**
 * @author Willing
 * @date 2019/1/29
 */
public class AccountServiceImpl implements IAccountService {

    @Setter
    private IAccountDAO accountDAO;

    @Override
    public void trans(Long outId, Long inId, Integer money) {
        accountDAO.transOut(outId,money);
        //System.out.println(1 / 0);//模拟停电
        accountDAO.transIn(inId,money);
    }
}
