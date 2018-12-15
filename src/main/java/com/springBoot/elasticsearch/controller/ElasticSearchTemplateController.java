package com.springBoot.elasticsearch.controller;


import com.alibaba.fastjson.JSONObject;
import com.springBoot.elasticsearch.dao.EmployeeRepository;
import com.springBoot.elasticsearch.domain.Employee;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Administrator
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchTemplateController {



    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    //增加
    @RequestMapping("/templateAdd")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        elasticsearchTemplate.putMapping("1","test",employee);
        System.err.println("add a obj");
        return "success";
    }


    //删除

    @RequestMapping("/templateDelete")

    public String delete() {

        elasticsearchTemplate.deleteIndex("1");
        return "success";

    }





}
