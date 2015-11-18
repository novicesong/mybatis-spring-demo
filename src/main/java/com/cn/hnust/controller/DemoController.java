package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Person;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Controller
@RequestMapping("/user")
public class DemoController {
    @Autowired
    private IUserService userService;

    /**
     * Class for output Log
     */
    private final Log log = LogFactory.getLog(getClass());

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        log.info("toIndex start");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        log.info("toIndex end");
        return "showUser";
    }

    @RequestMapping("/listUser")
    public String listUser(HttpServletRequest request, Model model) {
        log.info("toIndex start");
        log.info("toIndex end");
        return "listUser";
    }

    /**
     * User ID valid
     *
     * @param searchUser Search condition
     * @param userInfo   User info
     * @param request    HttpServletRequest
     * @return User admin page
     * @throws RakutenBaseException
     */
    @RequestMapping(value = "userIdValid")
    @ResponseBody
    public Map<String, Object> userIdValid(HttpServletRequest request) {
        log.info("userIdValid() start");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("userIdValidFlag", false);
        modelMap.put("userInfo", user);
        log.info("userIdValid() start");
        return modelMap;
    }


    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")

    @ResponseBody
    public String hello() {
        return "你好！hello";
    }

    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String say(@PathVariable(value = "msg") String msg) {
        return "{\"msg\":\"you say:'" + msg + "'\"}";
    }

    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable("id") int id) {
        log.info("获取人员信息id=" + id);
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(30);
        person.setId(id);
        return person;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public Object addPerson(Person person) {
        log.info("注册人员信息成功id=" + person.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "注册人员信息成功");
        return jsonObject;
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    @ResponseBody
    public Object updatePerson(Person person) {
        log.info("更新人员信息id=" + person.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "更新人员信息成功");
        return jsonObject;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {

        log.info("查询人员name like " + name);
        List<Person> lstPersons = new ArrayList<Person>();

        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(25);
        person.setId(101);
        lstPersons.add(person);

        Person person2 = new Person();
        person2.setName("李四");
        person2.setSex("女");
        person2.setAge(23);
        person2.setId(102);
        lstPersons.add(person2);

        Person person3 = new Person();
        person3.setName("王五");
        person3.setSex("男");
        person3.setAge(27);
        person3.setId(103);
        lstPersons.add(person3);

        return lstPersons;
    }

    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deletePerson(@PathVariable("id") int id) {
        log.info("删除人员信息id=" + id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "删除人员信息成功");
        return jsonObject;
    }

}
