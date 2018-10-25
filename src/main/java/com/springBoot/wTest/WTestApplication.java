package com.springBoot.wTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class WTestApplication {

	public static void main(String[] args) {
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
