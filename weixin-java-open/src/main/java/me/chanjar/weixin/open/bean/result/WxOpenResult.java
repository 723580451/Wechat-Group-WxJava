package me.chanjar.weixin.open.bean.result;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 基础的微信开放平台请求结果
 *
 * @author yqx
 * @date 2018/10/1
 */
@Data
public class WxOpenResult implements Serializable {
  protected String errcode;
  protected String errmsg;

  /**
   * 请求是否成功
   *
   * @return
   */
  public boolean isSuccess() {
    return StringUtils.equalsIgnoreCase(errcode, "0");
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
