package com.springBoot.jdbcConn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.validation.constraints.Max;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class demoJdbcService {
    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<userEntity> queryContent(Map map) {
        String sql = "select 1 from  dual";
        return jdbcTemplate.query(sql, new RowMapper<userEntity>() {
            public userEntity mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                userEntity cc = new userEntity();
                cc.setId(rs.getInt("id"));

                return cc;
            }
        });
    }
}
