package com.springBoot.redisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @javadoc
 * @author 1
 */
@Controller
public class RedisServiceController {
    @Autowired
    private RedisServiceImpl service;

    //添加
    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        System.out.println("start.....");
        RedisModel m = new RedisModel();
        m.setName("张三");
        m.setTel("1111");
        m.setAddress("深圳1");
        m.setRedisKey("zhangsanKey01");
        service.put(m.getRedisKey(), m, -1);

        System.out.println("add success end...");
        return new String("add success end...");

    }

}
