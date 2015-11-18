package com.cn.hnust.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api")
public class UserController {
	@Resource
	private IUserService userService;
	
	/** Class for output Log */
	private final Log log = LogFactory.getLog(getClass());
	
    @RequestMapping(value = "/person", method = RequestMethod.POST)  
    public @ResponseBody  
    Object addPerson(User person) {  
    	log.info("注册人员信息成功=" + person.toString());  
        JSONObject jsonObject = new JSONObject();  
        this.userService.insertSelective(person);
        jsonObject.put("msg", "注册人员信息成功");  
        return jsonObject;  
    }
 
}
