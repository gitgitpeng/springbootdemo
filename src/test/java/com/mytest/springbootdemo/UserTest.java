package com.mytest.springbootdemo;

import java.io.IOException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

/**
 * TODO: detail description
 *
 * @author xie.huanpeng
 * @version $: UserTest.java, v 0.1 2018年10月08日 14:31 xie.huanpeng Exp $
 */
public class UserTest {

  private final String REQ_URL = "http://127.0.0.1:8080/user";

  @Test
  public void add() throws IOException {
    String url = REQ_URL + "/add";
    String body = "{\"userId\":\"123\",\"userName\":\"xhptest432\",\"password\":\"1234\",\"phone\":\"13333555\"}";
    Request request = Request.Post(url).bodyString(body, ContentType.APPLICATION_JSON);
    String data = request.execute().returnContent().asString();
    System.out.println(data);
  }

  @Test
  public void delete() throws IOException {
    String url = REQ_URL + "/delete";
    Request request = Request.Post(url).bodyForm(new BasicNameValuePair("userId","13"));
    String data = request.execute().returnContent().asString();
    System.out.println(data);
  }

  @Test
  public void update() throws IOException {
    String url = REQ_URL + "/update";
    String body = "{\"userId\":\"2\",\"userName\":\"xhptest1111\",\"password\":\"1234\",\"phone\":\"13333\"}";
    Request request = Request.Post(url).bodyString(body, ContentType.APPLICATION_JSON);
    String data = request.execute().returnContent().asString();
    System.out.println(data);
  }

  @Test
  public void queryById() throws IOException {
    String url = REQ_URL + "/queryById";
    Request request = Request.Post(url).bodyForm(new BasicNameValuePair("userId","2"));
    String data = request.execute().returnContent().asString();
    System.out.println(data);
  }

  @Test
  public void queryList() throws IOException {
    String url = REQ_URL + "/queryList";
    String body = "{\"pageIndex\":2,\"pageSize\":20,\"query\":\"{}\"}";
    Request request = Request.Post(url).bodyString(body,ContentType.APPLICATION_JSON);
    String data = request.execute().returnContent().asString();
    System.out.println(data);
  }
}
