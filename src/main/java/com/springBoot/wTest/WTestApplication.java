package com.springBoot.wTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Controller
@SpringBootApplication
@ComponentScan(basePackages="com.springBoot")
//ElasticsearchRepository 接口扫描
@EnableElasticsearchRepositories("com.springBoot.elasticsearch.dao")
public class WTestApplication {

	public static void main(String[] args) {
		System.setProperty("es.set.netty.runtime.available.processors","false");

		SpringApplication.run(WTestApplication.class, args);
	}
	@RequestMapping("/")
	@ResponseBody
	public  Map<String,Object> firstPage(){
		Map<String,Object> info=new HashMap<String ,Object>();
		info.put("111","111");
		return info;
	}

	@RequestMapping("/S")
	@ResponseBody
	public String  firstPageString(){
		return "Hello World";
	}



}
