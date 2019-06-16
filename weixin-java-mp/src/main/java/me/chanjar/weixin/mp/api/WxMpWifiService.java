package me.chanjar.weixin.mp.api;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.wifi.WxMpWifiShopDataResult;
import me.chanjar.weixin.mp.bean.wifi.WxMpWifiShopListResult;

/**
 * <pre>
 *  微信连接WI-FI接口.
 *  Created by BinaryWang on 2018/6/10.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public interface WxMpWifiService {
  /**
   * <pre>
   * 获取Wi-Fi门店列表.
   * 通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。创建门店方法请参考“微信门店接口”。
   * 注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
   *
   * http请求方式: POST
   * 请求URL：https://api.weixin.qq.com/bizwifi/shop/list?access_token=ACCESS_TOKEN
   * </pre>
   *
   * @param pageIndex 分页下标，默认从1开始
   * @param pageSize  每页的个数，默认10个，最大20个
   * @return 结果
   * @throws WxErrorException 异常
   */
  WxMpWifiShopListResult listShop(int pageIndex, int pageSize) throws WxErrorException;

  /**
   * <pre>
   * 查询门店Wi-Fi信息
   * 通过此接口查询某一门店的详细Wi-Fi信息，包括门店内的设备类型、ssid、密码、设备数量、商家主页URL、顶部常驻入口文案。
   *
   * http请求方式: POST
   * 请求URL：https://api.weixin.qq.com/bizwifi/shop/get?access_token=ACCESS_TOKEN
   * POST数据格式：JSON
   * </pre>
   *
   * @param shopId 门店ID
   * @return 结果
   * @throws WxErrorException 异常
   */
  WxMpWifiShopDataResult getShopWifiInfo(int shopId) throws WxErrorException;
}
