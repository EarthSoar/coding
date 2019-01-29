package tx.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import tx.dao.IAccountDAO;

import javax.sql.DataSource;


/**
 * @author Willing
 * @date 2019/1/29
 */
public class AccountImpl implements IAccountDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transOut(Long id, Integer money) {
        jdbcTemplate.update("UPDATE accounts SET blance = blance - ? WHERE id = ?",money,id);
    }

    @Override
    public void transIn(Long id, Integer money) {
        jdbcTemplate.update("UPDATE accounts SET blance = blance + ? WHERE id = ?",money,id);
    }
}
