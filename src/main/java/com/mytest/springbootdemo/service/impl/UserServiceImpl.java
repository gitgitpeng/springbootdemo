package com.mytest.springbootdemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mytest.springbootdemo.common.PageData;
import com.mytest.springbootdemo.mapper.UserMapper;
import com.mytest.springbootdemo.model.User;
import com.mytest.springbootdemo.query.PageReq;
import com.mytest.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service实现类
 *
 * @author xie.huanpeng
 * @version $: UserServiceImpl.java, v 0.1 2018年09月30日 11:03 xie.huanpeng Exp $
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public Boolean add(User user) {
    int n = userMapper.insert(user);
    if (n > 0) {
      return true;
    }
    return false;
  }

  @Override
  public Boolean update(User user) {
    int n = userMapper.updateByPrimaryKeySelective(user);
    if (n > 0) {
      return true;
    }
    return false;
  }

  @Override
  public Boolean delete(String userId) {
    int n = userMapper.deleteByPrimaryKey(Long.valueOf(userId));
    if (n > 0) {
      return true;
    }
    return false;
  }

  @Override
  public User queryById(String userId) {
    return userMapper.selectByPrimaryKey(Long.valueOf(userId));
  }

  @Override
  public PageData<User> queryList(PageReq pageReq) {
    PageHelper.startPage(pageReq.getPageIndex(), pageReq.getPageSize());
    Page<User>     page     = userMapper.queryList();
    PageData<User> pageData = new PageData<>();
    pageData.setPageSize(page.getPageSize());
    pageData.setPageNum(page.getPageNum());
    pageData.setTotalSize((int) page.getTotal());
    pageData.setTotalPage(page.getPages());
    pageData.setData(page.getResult());
    return pageData;
  }
}
