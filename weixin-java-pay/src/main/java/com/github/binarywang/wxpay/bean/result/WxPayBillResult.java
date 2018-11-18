package com.github.binarywang.wxpay.bean.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.json.WxGsonBuilder;

/**
 * 微信对账单结果类.
 *
 * @author DDLeEHi
 */
@Data
@NoArgsConstructor
public class WxPayBillResult implements Serializable {
  private static final String TOTAL_DEAL_COUNT = "总交易单数";
  private static final long serialVersionUID = -7687458652694204070L;

  @Override
  public String toString() {
    return WxGsonBuilder.create().toJson(this);
  }

  /**
   * 对账明细列表.
   */
  private List<WxPayBillInfo> billInfoList;
  /**
   * 总交易单数.
   */
  private String totalRecord;
  /**
   * 应结订单总金额.
   */
  private String totalFee;
  /**
   * 退款总金额.
   */
  private String totalRefundFee;
  /**
   * 充值券退款总金额.
   */
  private String totalCouponFee;
  /**
   * 手续费总金额.
   */
  private String totalPoundageFee;
  /**
   * 订单总金额.
   */
  private String totalAmount;
  /**
   * 申请退款总金额.
   */
  private String totalAppliedRefundFee;

  /**
   * 从原始对账单字符串里构造出WxPayBillResult对象.
   */
  public static WxPayBillResult fromRawBillResultString(String responseContent) {
    String listStr = "";
    String objStr = "";
    if (responseContent.contains(TOTAL_DEAL_COUNT)) {
      listStr = responseContent.substring(0, responseContent.indexOf(TOTAL_DEAL_COUNT));
      objStr = responseContent.substring(responseContent.indexOf(TOTAL_DEAL_COUNT));
    }

    List<WxPayBillInfo> results = new ArrayList<>();
    // 去空格
    String newStr = listStr.replaceAll(",", " ");
    // 数据分组
    String[] tempStr = newStr.split("`");
    // 分组标题
    String[] t = tempStr[0].split(" ");
    // 计算循环次数
    int j = tempStr.length / t.length;
    // 纪录数组下标
    int k = 1;
    for (int i = 0; i < j; i++) {
      WxPayBillInfo result = new WxPayBillInfo();
      result.setTradeTime(tempStr[k].trim());
      result.setAppId(tempStr[k + 1].trim());
      result.setMchId(tempStr[k + 2].trim());
      result.setSubMchId(tempStr[k + 3].trim());
      result.setDeviceInfo(tempStr[k + 4].trim());
      result.setTransactionId(tempStr[k + 5].trim());
      result.setOutTradeNo(tempStr[k + 6].trim());
      result.setOpenId(tempStr[k + 7].trim());
      result.setTradeType(tempStr[k + 8].trim());
      result.setTradeState(tempStr[k + 9].trim());
      result.setBankType(tempStr[k + 10].trim());
      result.setFeeType(tempStr[k + 11].trim());
      result.setTotalFee(tempStr[k + 12].trim());
      result.setCouponFee(tempStr[k + 13].trim());
      result.setRefundId(tempStr[k + 14].trim());
      result.setOutRefundNo(tempStr[k + 15].trim());
      result.setSettlementRefundFee(tempStr[k + 16].trim());
      result.setCouponRefundFee(tempStr[k + 17].trim());
      result.setRefundChannel(tempStr[k + 18].trim());
      result.setRefundState(tempStr[k + 19].trim());
      result.setBody(tempStr[k + 20].trim());
      result.setAttach(tempStr[k + 21].trim());
      result.setPoundage(tempStr[k + 22].trim());
      result.setPoundageRate(tempStr[k + 23].trim());
      result.setTotalAmount(tempStr[k + 24].trim());
      result.setAppliedRefundAmount(tempStr[k + 25].trim());
      result.setFeeRemark(tempStr[k + 26].trim());
      results.add(result);
      k += t.length;
    }

    WxPayBillResult billResult = new WxPayBillResult();
    billResult.setBillInfoList(results);

    /*
     * 总交易单数,应结订单总金额,退款总金额,充值券退款总金额,手续费总金额,订单总金额,申请退款总金额 `2,`0.02,`0.0,`0.0,`0
     * 参考以上格式进行取值
     */
    String[] totalTempStr = objStr.replaceAll(",", " ").split("`");
    billResult.setTotalRecord(totalTempStr[1]);
    billResult.setTotalFee(totalTempStr[2]);
    billResult.setTotalRefundFee(totalTempStr[3]);
    billResult.setTotalCouponFee(totalTempStr[4]);
    billResult.setTotalPoundageFee(totalTempStr[5]);
    billResult.setTotalAmount(totalTempStr[6]);
    billResult.setTotalAppliedRefundFee(totalTempStr[7]);

    return billResult;
  }
}
