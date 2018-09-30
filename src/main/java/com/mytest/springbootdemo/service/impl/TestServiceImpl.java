package com.mytest.springbootdemo.service.impl;

import com.mytest.springbootdemo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: TestServiceImpl.java, v 0.1 2018年09月30日 11:03 xie.huanpeng Exp $
 */
@Service
public class TestServiceImpl implements TestService {

  private static final String WELCOME_WORD = "hello world";

  @Override
  public String welcome() {
    return WELCOME_WORD;
  }
}
