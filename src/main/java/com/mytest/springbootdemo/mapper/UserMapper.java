package com.mytest.springbootdemo.mapper;

import com.github.pagehelper.Page;
import com.mytest.springbootdemo.model.User;
import org.springframework.stereotype.Component;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: UserMapper.java, v 0.1 2018年09月30日 11:01 xie.huanpeng Exp $
 */
public interface UserMapper {

  int deleteByPrimaryKey(Long userId);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Long userId);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  Page<User> queryList();
}