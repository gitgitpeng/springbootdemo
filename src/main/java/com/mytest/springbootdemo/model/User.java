package com.mytest.springbootdemo.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: User.java, v 0.1 2018年09月30日 11:01 xie.huanpeng Exp $
 */
@Setter
@Getter
public class User implements Serializable {

  private String userName;

  private String password;

  private String phone;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}