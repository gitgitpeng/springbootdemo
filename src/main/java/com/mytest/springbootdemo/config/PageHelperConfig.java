package com.mytest.springbootdemo.config;

import com.github.pagehelper.PageHelper;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: PageHelperConfig.java, v 0.1 2018年09月30日 14:23 xie.huanpeng Exp $
 */
@Configuration
public class PageHelperConfig {

  /**
   * 注入pagehelper配置
   *
   * @return
   */
  @Bean
  public PageHelper getPageHelper() {
    PageHelper pageHelper = new PageHelper();
    Properties properties = new Properties();
    properties.setProperty("helperDialect", "mysql");
    properties.setProperty("reasonable", "false");
    properties.setProperty("supportMethodsArguments", "true");
    properties.setProperty("params", "count=countSql");
    pageHelper.setProperties(properties);
    return pageHelper;
  }

}
