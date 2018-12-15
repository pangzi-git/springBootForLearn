package com.springBoot.mySql.jdbcService;

import com.springBoot.mySql.jdbcDomain.User;


/**
 *
 * @author j
 */
public interface UserService {
    boolean save(User user);
}
