package com.mytest.springbootdemo.utils;

import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

/**
 * 属性复制工具
 *
 * @author tangdu
 * @version $: ObjectUtils.java, v 0.1 2018年08月28日 22:30 tangdu Exp $
 */
public class ObjectUtils {

  private static Map<String, BeanCopier> BEAN_COPIER_MAP = Maps.newHashMap();

  public static <T> T copyProperties(Object source, Object target) {
    String     beanKey = generateKey(source.getClass(), target.getClass());
    BeanCopier copier  = null;
    if (!BEAN_COPIER_MAP.containsKey(beanKey)) {
      copier = BeanCopier.create(source.getClass(), target.getClass(), false);
      BEAN_COPIER_MAP.put(beanKey, copier);
    } else {
      copier = BEAN_COPIER_MAP.get(beanKey);
    }
    copier.copy(source, target, null);
    return (T) target;
  }

  public static <T> T copyProperties(Object source, Class<T> target) {
    T t = BeanUtils.instantiate(target);
    copyProperties(source, t);
    return t;
  }

  private static String generateKey(Class<?> class1, Class<?> class2) {
    return class1.toString() + class2.toString();
  }

  public static <T> T copy(Object source, T target, String... ingoreProps) {
    BeanUtils.copyProperties(source, target, ingoreProps);
    return target;
  }

  public static <T> T copy(Object source, Class<T> targetClass, String... ingoreProps) {
    T t = BeanUtils.instantiate(targetClass);
    BeanUtils.copyProperties(source, t, ingoreProps);
    return t;
  }

  public static <T> List<T> copyList(List<?> list, Class<T> target, String... ingoreProps) {
    List<T> result = new ArrayList<>();
    if (CollectionUtils.isEmpty(list)) {
      return result;
    }
    for (Object object : list) {
      result.add(copy(object, target, ingoreProps));
    }
    return result;
  }
}
