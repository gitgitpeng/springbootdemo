package com.mytest.springbootdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: Guest.java, v 0.1 2018年09月28日 13:40 xie.huanpeng Exp $
 */
@Setter
@Getter
public class Guest {

  private String name;
  private int    sex;
  private String note;
  private String arg1;
  private String arg2;
  private String arg3;
  private String arg4;
  private String arg5;
  private String arg6;

  public String getArg7() {
    return "1111";
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
