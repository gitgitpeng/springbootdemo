package com.mytest.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mytest.springbootdemo.model.Guest;
import com.mytest.springbootdemo.service.TestService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: TestController.java, v 0.1 2018年09月28日 11:31 xie.huanpeng Exp $
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
  @Autowired
  private TestService testService;

  @RequestMapping("/hello")
  public String hello(){
    return testService.welcome();
  }

  @RequestMapping("/compareJson")
  public void compareJson(){
    Gson gson = new Gson();
    String json = "{\"name\":\"zhangsan\",\"sex\":0,\"note\":\"i am a man\",\"arg1\":\"aaaaaaaaaaaaaa\",\"arg2\":\"bbbbbbbbbbbbbbbbb\",\"arg3\":\"ccccccccccccccccccccc\",\"arg4\":\"dddddddddddddddddd\",\"arg5\":\"eeeeeeeeeeeeee\",\"arg6\":\"ffffffffffffffffffffffff\"}";
    Date before = new Date();
    Guest guest = gson.fromJson(json,Guest.class);
    String parseJson  = gson.toJson(guest);
    System.out.println(parseJson);
    Date after = new Date();
    System.out.println("Gson: json -> object -> json spend:"+(after.getTime() - before.getTime()));
    before = new Date();
    Guest guest1 = JSONObject.parseObject(json,Guest.class);
    String parseJson1 = JSONObject.toJSONString(guest1);
    System.out.println(parseJson1);
    after = new Date();
    System.out.println("FastJson: json -> object -> json spend:"+(after.getTime() - before.getTime()));
  }

  @RequestMapping("testLog")
  public void testLog(){
    log.debug("debug log....");
    log.error("error log....");
    log.info("info log....");
    log.warn("warn log....");
  }
}
