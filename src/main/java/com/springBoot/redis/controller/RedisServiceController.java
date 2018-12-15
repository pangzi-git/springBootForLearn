package com.springBoot.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.springBoot.redis.redisDomain.RedisModel;
import com.springBoot.redis.redisService.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    //添加
    @RequestMapping(value = "/redisTemp", method = RequestMethod.GET)
    @ResponseBody
    public String redisTemp() throws UnsupportedEncodingException {
        System.out.println("start.....");
        RedisModel m = new RedisModel();
        m.setName("张三11");
        m.setTel("1111");
        m.setAddress("深圳1");
        m.setRedisKey("zhangsanKey02");
        //""里面的参数为需要转化的编码，一般是ISO8859-1
        byte[] bytes = JSONObject.toJSONString(m).getBytes("ISO8859-1");
        //转化为utf-8编码
        String str = new String(bytes,"utf-8");
        redisTemplate.opsForValue().set(m.getRedisKey(),str);

        System.out.println("add success end...");
        return new String("add success end...");

    }
    @Resource
    protected RedisTemplate<String, Object>   functionDomainRedisTemplate;
    //添加
    @RequestMapping(value = "/DomainRedisTemp", method = RequestMethod.GET)
    @ResponseBody
    public String DomainRedisTemp() throws UnsupportedEncodingException {
        System.out.println("start.....");
        final String key = String.format("bank:%s", "JACK");
        final Map<String, Object> properties = new HashMap<String, Object>();

        properties.put("id", "11111");
        properties.put("name","JACK");

        functionDomainRedisTemplate.opsForValue().set(key,properties.toString());

        System.out.println("add success end...");
        return new String("add success end...");

    }

}
