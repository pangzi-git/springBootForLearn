package com.springBoot.mySql.jdbcDomain;

import com.springBoot.mySql.jdbcService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
@EnableTransactionManagement
public class UserImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Override
    @Transactional(rollbackForClassName="com.springBoot.mySql.jdbcService.UserService")
    public boolean save(final User user) {
        Boolean result = jdbcTemplate.execute("INSERT INTO user(name,age) VALUES(?,?);", new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, user.getName());
                ps.setInt(2, user.getAge());
                return ps.executeUpdate() > 0;
            }

        });

        return result;
    }
}
