package com.mytest.springbootdemo.service;

import com.mytest.springbootdemo.common.PageData;
import com.mytest.springbootdemo.model.User;
import com.mytest.springbootdemo.query.PageReq;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: UserService.java, v 0.1 2018年09月30日 10:55 xie.huanpeng Exp $
 */
public interface UserService {

  /**
   * 新增
   *
   * @param user
   * @return
   */
  Boolean add(User user);

  /**
   * 修改
   *
   * @param user
   * @return
   */
  Boolean update(User user);

  /**
   * 删除
   *
   * @param userId
   * @return
   */
  Boolean delete(String userId);

  /**
   * 根据用户ID查询
   *
   * @param userId
   * @return
   */
  User queryById(String userId);

  /**
   * 查询所有用户
   *
   * @param pageReq
   * @return
   */
  PageData<User> queryList(PageReq pageReq);
}
