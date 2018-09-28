package com.mytest.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: TestService.java, v 0.1 2018年09月28日 11:31 xie.huanpeng Exp $
 */
@Service
public class TestService {

  private static final String WELCOME_WORD = "hello world";

  public String welcome(){
    return WELCOME_WORD;
  }
}
