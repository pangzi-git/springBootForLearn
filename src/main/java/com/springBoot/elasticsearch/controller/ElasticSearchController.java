package com.springBoot.elasticsearch.controller;


import com.alibaba.fastjson.JSONObject;
import com.springBoot.elasticsearch.dao.EmployeeRepository;
import com.springBoot.elasticsearch.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Administrator
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    private EmployeeRepository er;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    //增加
    @RequestMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        er.save(employee);
        System.err.println("add a obj");
        return "success";
    }


    //删除

    @RequestMapping("/delete")

    public String delete() {


        er.deleteById("1");


        return "success";

    }


    //局部更新

    @RequestMapping("/update")

    public String update() {


        Employee employee = er.queryEmployeeById("1");

        employee.setFirstName("哈哈");

        er.save(employee);


        System.err.println("update a obj");


        return "success";

    }


    //查询

    @RequestMapping("/query")

    public Employee query() {


        Employee accountInfo = er.queryEmployeeById("1");

        System.err.println(JSONObject.toJSONString(accountInfo));


        return accountInfo;

    }


}
