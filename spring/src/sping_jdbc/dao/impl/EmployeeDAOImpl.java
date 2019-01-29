package sping_jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sping_jdbc.dao.IEmployeeDAO;
import sping_jdbc.domain.Employee;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Willing
 * @date 2019/1/28
 */
public class EmployeeDAOImpl implements IEmployeeDAO{

    private JdbcTemplate jdbcTemplate;
    //属性名：dataSource
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee e) {
        jdbcTemplate.update("INSERT INTO employee(name,age) VALUES (?,?)",e.getName(),e.getAge());
    }

    @Override
    public void delete(Employee e) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?",e.getId());
    }

    @Override
    public void update(Employee e) {
        jdbcTemplate.update("UPDATE employee SET name = ? age = ?",e.getName(),e.getAge());
    }

    @Override
    public Employee get(Long id) {
        List<Employee> list = jdbcTemplate.query("SELECT * FROM employee WHERE id = ?", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));
                return employee;
            }
        }, id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Employee> list() {
        return jdbcTemplate.query("SELECT *FROM employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));
                return employee;
            }
        });
    }
}
