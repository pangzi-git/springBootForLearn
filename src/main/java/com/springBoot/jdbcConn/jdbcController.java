package com.springBoot.jdbcConn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class jdbcController {
    @Autowired
    demoJdbcService demoJdbcService;

    @RequestMapping("/jdbcTest")
    @ResponseBody
    public List<userEntity> test() {
        int i=0;
        return  demoJdbcService.queryContent(new HashMap());
    }
}
