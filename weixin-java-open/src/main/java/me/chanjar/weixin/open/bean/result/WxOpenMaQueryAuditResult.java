package me.chanjar.weixin.open.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author yqx
 * @date 2018/10/3
 */
@Data
public class WxOpenMaQueryAuditResult extends WxOpenResult {
  /**
   * 审核编号
   */
  @SerializedName("auditid")
  Long auditId;

  /**
   * 审核状态:2-审核中,0-审核通过,1-审核失败
   */
  Integer status;

  /**
   * 审核失败原因
   */
  String reason;
}
