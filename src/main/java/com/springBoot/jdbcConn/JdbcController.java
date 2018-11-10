package com.springBoot.jdbcConn;

import com.springBoot.jdbcDomain.User;
import com.springBoot.jdbcService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JdbcController {
    @Autowired
    demoJdbcService demoJdbcService;

    @Autowired
    private UserService userService;

    @RequestMapping("/jdbcTest")
    @ResponseBody
    public List<userEntity> test() {
        int i=0;
        return  demoJdbcService.queryContent(new HashMap());
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("success", userService.save(user));

        return data;
    }
}
