package me.chanjar.weixin.open.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 微信开放平台小程序域名设置返回对象
 *
 * @author yqx
 * @date 2018/9/12
 */
@Data
public class WxOpenMaDomainResult extends WxOpenResult {

  @SerializedName("requestdomain")
  List<String> requestdomainList;

  @SerializedName("wsrequestdomain")
  List<String> wsrequestdomainList;

  @SerializedName("uploaddomain")
  List<String> uploaddomainList;

  @SerializedName("downloaddomain")
  List<String> downloaddomainList;

}
