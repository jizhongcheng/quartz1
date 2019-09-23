package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.dao.TestDao;
import com.etoak.quartz.springmvcQuartz.DynamicJobFactory;


@Controller
public class TestController {
	@Autowired
	private TestDao testDao;
	
	@Resource
    private DynamicJobFactory dynamicJobFactory;
 
    String className = "com.etoak.quartz.springmvcQuartz.QuartzTimer";
 
    String cronExpression = "0/2 * * * * ?";

//	http://localhost:8080/start
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public String start(){
		try {
            dynamicJobFactory.addJob(className, cronExpression);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "start success";
	}

	@RequestMapping(value = "/end", method = RequestMethod.GET)
	@ResponseBody
	public String end(){
		try {
            dynamicJobFactory.stopJob(className);
		} catch (Exception e){
			e.printStackTrace();
		}
		return "end success";
	}
	
	@RequestMapping(value = "/selectuser", method = RequestMethod.POST)  
	@ResponseBody 
	public String selectUser(){
		System.out.println("======================000");
		Map map = new HashMap();
		List<User> list = testDao.selectUser();
		return "0000";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		System.out.println("登录成功");
		return "index";
	}
}
