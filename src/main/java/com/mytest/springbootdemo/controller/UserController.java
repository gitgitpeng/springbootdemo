package com.mytest.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.mytest.springbootdemo.model.User;
import com.mytest.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: UserController.java, v 0.1 2018年09月30日 10:53 xie.huanpeng Exp $
 */
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("add")
  public String add(@RequestBody String user) {
    if (!StringUtils.hasLength(user)) {
      return "wrong params...";
    }
    User    user1     = JSONObject.parseObject(user, User.class);
    Boolean isSuccess = userService.add(user1);
    if (isSuccess) {
      return "add user success...";
    }
    return "add user fail...";
  }

  @PostMapping("delete")
  public String delete(@RequestParam("userId") String userId) {
    if (!StringUtils.hasLength(userId)) {
      return "wrong params...";
    }
    Boolean isSuccess = userService.delete(userId);
    if (isSuccess) {
      return "delete user success...";
    }
    return "delete user fail...";
  }

  @PostMapping("update")
  public String update(@RequestBody String user) {
    if (!StringUtils.hasLength(user)) {
      return "wrong params...";
    }
    User    user1     = JSONObject.parseObject(user, User.class);
    Boolean isSuccess = userService.update(user1);
    if (isSuccess) {
      return "update user success...";
    }
    return "update user fail...";
  }

  @PostMapping("queryById")
  public String queryById(@RequestParam("userId") String userId) {
    if (!StringUtils.hasLength(userId)) {
      return "wrong params...";
    }
    User user = userService.queryById(userId);
    if (user != null) {
      return user.toString();
    }
    return "no user";
  }

  @RequestMapping("queryList")
  public String queryList() {
    return userService.queryList().toString();
  }

}
