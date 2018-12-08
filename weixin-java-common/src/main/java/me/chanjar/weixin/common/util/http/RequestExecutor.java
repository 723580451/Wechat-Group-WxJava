package me.chanjar.weixin.common.util.http;

import java.io.IOException;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * http请求执行器.
 *
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 * @author Daniel Qian
 */
public interface RequestExecutor<T, E> {

  /**
   * 执行http请求.
   *
   * @param uri  uri
   * @param data 数据
   */
  T execute(String uri, E data) throws WxErrorException, IOException;
}
