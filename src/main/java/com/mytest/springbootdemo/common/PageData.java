package com.mytest.springbootdemo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用分页对象
 *
 * @author xie.huanpeng
 * @version $: PageData.java, v 0.1 2018年09月30日 11:16 xie.huanpeng Exp $
 */
@Setter
@Getter
public class PageData<T extends Serializable> implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 分页大小
   */
  public Integer pageSize = 20;

  /**
   * 页码
   */
  public Integer pageNum = 1;

  /**
   * 结果总数
   */
  public Integer totalSize;

  /**
   * 总分页数
   */
  public Integer totalPage;

  /**
   * 数据
   */
  public List<T> data;

  public Integer getTotalPage() {
    return totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this, SerializerFeature.WriteDateUseDateFormat);
  }

}
