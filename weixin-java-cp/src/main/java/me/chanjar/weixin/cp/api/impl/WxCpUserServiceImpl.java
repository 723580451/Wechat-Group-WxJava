package me.chanjar.weixin.cp.api.impl;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.bean.WxCpInviteResult;
import me.chanjar.weixin.cp.bean.WxCpUser;
import me.chanjar.weixin.cp.bean.WxCpUserExternalContactInfo;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * <pre>
 *  Created by BinaryWang on 2017/6/24.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxCpUserServiceImpl implements WxCpUserService {
  private final WxCpService mainService;

  public WxCpUserServiceImpl(WxCpService mainService) {
    this.mainService = mainService;
  }

  @Override
  public void authenticate(String userId) throws WxErrorException {
    this.mainService.get(WxCpUserService.URL_AUTHENTICATE + userId, null);
  }

  @Override
  public void create(WxCpUser user) throws WxErrorException {
    this.mainService.post(WxCpUserService.URL_USER_CREATE, user.toJson());
  }

  @Override
  public void update(WxCpUser user) throws WxErrorException {
    this.mainService.post(WxCpUserService.URL_USER_UPDATE, user.toJson());
  }

  @Override
  public void delete(String... userIds) throws WxErrorException {
    if (userIds.length == 1) {
      this.mainService.get(WxCpUserService.URL_USER_DELETE + userIds[0], null);
      return;
    }

    JsonObject jsonObject = new JsonObject();
    JsonArray jsonArray = new JsonArray();
    for (String userId : userIds) {
      jsonArray.add(new JsonPrimitive(userId));
    }

    jsonObject.add("useridlist", jsonArray);
    this.mainService.post(WxCpUserService.URL_USER_BATCH_DELETE, jsonObject.toString());
  }

  @Override
  public WxCpUser getById(String userid) throws WxErrorException {
    String responseContent = this.mainService.get(WxCpUserService.URL_USER_GET + userid, null);
    return WxCpUser.fromJson(responseContent);
  }

  @Override
  public List<WxCpUser> listByDepartment(Long departId, Boolean fetchChild, Integer status) throws WxErrorException {
    String params = "";
    if (fetchChild != null) {
      params += "&fetch_child=" + (fetchChild ? "1" : "0");
    }
    if (status != null) {
      params += "&status=" + status;
    } else {
      params += "&status=0";
    }

    String responseContent = this.mainService.get(WxCpUserService.URL_USER_LIST + departId, params);
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    return WxCpGsonBuilder.create()
      .fromJson(tmpJsonElement.getAsJsonObject().get("userlist"),
        new TypeToken<List<WxCpUser>>() {
        }.getType()
      );
  }

  @Override
  public List<WxCpUser> listSimpleByDepartment(Long departId, Boolean fetchChild, Integer status) throws WxErrorException {
    String params = "";
    if (fetchChild != null) {
      params += "&fetch_child=" + (fetchChild ? "1" : "0");
    }
    if (status != null) {
      params += "&status=" + status;
    } else {
      params += "&status=0";
    }

    String responseContent = this.mainService.get(WxCpUserService.URL_USER_SIMPLE_LIST + departId, params);
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    return WxCpGsonBuilder.create()
      .fromJson(
        tmpJsonElement.getAsJsonObject().get("userlist"),
        new TypeToken<List<WxCpUser>>() {
        }.getType()
      );
  }

  @Override
  public WxCpInviteResult invite(List<String> userIds, List<String> partyIds, List<String> tagIds) throws WxErrorException {
    JsonObject jsonObject = new JsonObject();
    if (userIds != null) {
      JsonArray jsonArray = new JsonArray();
      for (String userId : userIds) {
        jsonArray.add(new JsonPrimitive(userId));
      }
      jsonObject.add("user", jsonArray);
    }

    if (partyIds != null) {
      JsonArray jsonArray = new JsonArray();
      for (String userId : partyIds) {
        jsonArray.add(new JsonPrimitive(userId));
      }
      jsonObject.add("party", jsonArray);
    }

    if (tagIds != null) {
      JsonArray jsonArray = new JsonArray();
      for (String tagId : tagIds) {
        jsonArray.add(new JsonPrimitive(tagId));
      }
      jsonObject.add("tag", jsonArray);
    }

    return WxCpInviteResult.fromJson(this.mainService.post(WxCpUserService.URL_BATCH_INVITE, jsonObject.toString()));
  }

  @Override
  public Map<String, String> userId2Openid(String userId, Integer agentId) throws WxErrorException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("userid", userId);
    if (agentId != null) {
      jsonObject.addProperty("agentid", agentId);
    }

    String responseContent = this.mainService.post(WxCpUserService.URL_CONVERT_TO_OPENID, jsonObject.toString());
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    Map<String, String> result = Maps.newHashMap();
    if (tmpJsonElement.getAsJsonObject().get("openid") != null) {
      result.put("openid", tmpJsonElement.getAsJsonObject().get("openid").getAsString());
    }

    if (tmpJsonElement.getAsJsonObject().get("appid") != null) {
      result.put("appid", tmpJsonElement.getAsJsonObject().get("appid").getAsString());
    }

    return result;
  }

  @Override
  public String openid2UserId(String openid) throws WxErrorException {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("openid", openid);
    String responseContent = this.mainService.post(WxCpUserService.URL_CONVERT_TO_USERID, jsonObject.toString());
    JsonElement tmpJsonElement = new JsonParser().parse(responseContent);
    return tmpJsonElement.getAsJsonObject().get("userid").getAsString();
  }

  @Override
  public WxCpUserExternalContactInfo getExternalContact(String userId) throws WxErrorException {
    String responseContent = this.mainService.get(WxCpUserService.URL_GET_EXTERNAL_CONTACT + userId, null);
    return WxCpUserExternalContactInfo.fromJson(responseContent);
  }
}
