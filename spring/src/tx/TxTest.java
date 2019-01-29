package tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tx.service.IAccountService;

/**
 * @author Willing
 * @date 2019/1/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TxTest {
    @Autowired
    private IAccountService service;

    @Test
    public void test(){
        service.trans(2L,1L,1000);
    }
}
