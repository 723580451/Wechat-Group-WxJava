package me.chanjar.weixin.mp.enums;

import lombok.AllArgsConstructor;

/**
 * <pre>
 *  公众号接口api地址
 *  Created by BinaryWang on 2019-06-03.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public interface WxMpApiUrl {
  String WX_API_BASE_URL = "https://api.weixin.qq.com";
  String WX_MP_BASE_URL = "https://mp.weixin.qq.com";
  String WX_OPEN_BASE_URL = "https://open.weixin.qq.com";

  /**
   * 得到api完整地址.
   *
   * @return api地址
   */
  String getUrl();

  @AllArgsConstructor
  enum Device implements WxMpApiUrl {
    /**
     * get_bind_device.
     */
    DEVICE_GET_BIND_DEVICE(WX_API_BASE_URL, "/device/get_bind_device"),
    /**
     * get_openid.
     */
    DEVICE_GET_OPENID(WX_API_BASE_URL, "/device/get_openid"),
    /**
     * compel_unbind.
     */
    DEVICE_COMPEL_UNBIND(WX_API_BASE_URL, "/device/compel_unbind?"),
    /**
     * unbind.
     */
    DEVICE_UNBIND(WX_API_BASE_URL, "/device/unbind?"),
    /**
     * compel_bind.
     */
    DEVICE_COMPEL_BIND(WX_API_BASE_URL, "/device/compel_bind"),
    /**
     * bind.
     */
    DEVICE_BIND(WX_API_BASE_URL, "/device/bind"),
    /**
     * authorize_device.
     */
    DEVICE_AUTHORIZE_DEVICE(WX_API_BASE_URL, "/device/authorize_device"),
    /**
     * getqrcode.
     */
    DEVICE_GETQRCODE(WX_API_BASE_URL, "/device/getqrcode"),
    /**
     * transmsg.
     */
    DEVICE_TRANSMSG(WX_API_BASE_URL, "/device/transmsg");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }


  @AllArgsConstructor
  enum Other implements WxMpApiUrl {
    /**
     * 获取access_token.
     */
    GET_ACCESS_TOKEN_URL(WX_API_BASE_URL, "/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s"),
    /**
     * 获得各种类型的ticket.
     */
    GET_TICKET_URL(WX_API_BASE_URL, "/cgi-bin/ticket/getticket?type="),
    /**
     * 长链接转短链接接口.
     */
    SHORTURL_API_URL(WX_API_BASE_URL, "/cgi-bin/shorturl"),
    /**
     * 语义查询接口.
     */
    SEMANTIC_SEMPROXY_SEARCH_URL(WX_API_BASE_URL, "/semantic/semproxy/search"),
    /**
     * 用code换取oauth2的access token.
     */
    OAUTH2_ACCESS_TOKEN_URL(WX_API_BASE_URL, "/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code"),
    /**
     * 刷新oauth2的access token.
     */
    OAUTH2_REFRESH_TOKEN_URL(WX_API_BASE_URL, "/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s"),
    /**
     * 用oauth2获取用户信息.
     */
    OAUTH2_USERINFO_URL(WX_API_BASE_URL, "/sns/userinfo?access_token=%s&openid=%s&lang=%s"),
    /**
     * 验证oauth2的access token是否有效.
     */
    OAUTH2_VALIDATE_TOKEN_URL(WX_API_BASE_URL, "/sns/auth?access_token=%s&openid=%s"),
    /**
     * 获取微信服务器IP地址.
     */
    GET_CALLBACK_IP_URL(WX_API_BASE_URL, "/cgi-bin/getcallbackip"),
    /**
     * 第三方使用网站应用授权登录的url.
     */
    QRCONNECT_URL(WX_OPEN_BASE_URL, "/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect"),
    /**
     * oauth2授权的url连接.
     */
    CONNECT_OAUTH2_AUTHORIZE_URL(WX_OPEN_BASE_URL, "/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&connect_redirect=1#wechat_redirect"),
    /**
     * 获取公众号的自动回复规则.
     */
    GET_CURRENT_AUTOREPLY_INFO_URL(WX_API_BASE_URL, "/cgi-bin/get_current_autoreply_info"),
    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零.
     */
    CLEAR_QUOTA_URL(WX_API_BASE_URL, "/cgi-bin/clear_quota");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Marketing implements WxMpApiUrl {
    /**
     * sets add.
     */
    USER_ACTION_SETS_ADD(WX_API_BASE_URL, "/marketing/user_action_sets/add?version=v1.0"),
    /**
     * get.
     */
    USER_ACTION_SETS_GET(WX_API_BASE_URL, "/marketing/user_action_sets/get"),
    /**
     * add.
     */
    USER_ACTIONS_ADD(WX_API_BASE_URL, "/marketing/user_actions/add?version=v1.0"),
    /**
     * get.
     */
    WECHAT_AD_LEADS_GET(WX_API_BASE_URL, "/marketing/wechat_ad_leads/get");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Menu implements WxMpApiUrl {
    /**
     * get_current_selfmenu_info.
     */
    GET_CURRENT_SELFMENU_INFO(WX_API_BASE_URL, "/cgi-bin/get_current_selfmenu_info"),
    /**
     * trymatch.
     */
    MENU_TRYMATCH(WX_API_BASE_URL, "/cgi-bin/menu/trymatch"),
    /**
     * get.
     */
    MENU_GET(WX_API_BASE_URL, "/cgi-bin/menu/get"),
    /**
     * delconditional.
     */
    MENU_DELCONDITIONAL(WX_API_BASE_URL, "/cgi-bin/menu/delconditional"),
    /**
     * delete.
     */
    MENU_DELETE(WX_API_BASE_URL, "/cgi-bin/menu/delete"),
    /**
     * create.
     */
    MENU_CREATE(WX_API_BASE_URL, "/cgi-bin/menu/create"),
    /**
     * addconditional.
     */
    MENU_ADDCONDITIONAL(WX_API_BASE_URL, "/cgi-bin/menu/addconditional");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }


  @AllArgsConstructor
  enum Qrcode implements WxMpApiUrl {
    /**
     * create.
     */
    QRCODE_CREATE(WX_API_BASE_URL, "/cgi-bin/qrcode/create"),
    /**
     * showqrcode.
     */
    SHOW_QRCODE(WX_MP_BASE_URL, "/cgi-bin/showqrcode"),
    /**
     * showqrcode.
     */
    SHOW_QRCODE_WITH_TICKET(WX_MP_BASE_URL, "/cgi-bin/showqrcode?ticket=%s");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum ShakeAround implements WxMpApiUrl {
    /**
     * getshakeinfo.
     */
    SHAKEAROUND_USER_GETSHAKEINFO(WX_API_BASE_URL, "/shakearound/user/getshakeinfo"),
    /**
     * add.
     */
    SHAKEAROUND_PAGE_ADD(WX_API_BASE_URL, "/shakearound/page/add"),
    /**
     * bindpage.
     */
    SHAKEAROUND_DEVICE_BINDPAGE(WX_API_BASE_URL, "/shakearound/device/bindpage"),
    /**
     * search.
     */
    SHAKEAROUND_RELATION_SEARCH(WX_API_BASE_URL, "/shakearound/relation/search");


    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum SubscribeMsg implements WxMpApiUrl {
    /**
     * subscribemsg.
     */
    SUBSCRIBE_MESSAGE_AUTHORIZE_URL(WX_MP_BASE_URL, "/mp/subscribemsg?action=get_confirm&appid=%s&scene=%d&template_id=%s&redirect_url=%s&reserved=%s#wechat_redirect"),
    /**
     * subscribe.
     */
    SEND_MESSAGE_URL(WX_API_BASE_URL, "/cgi-bin/message/template/subscribe");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum TemplateMsg implements WxMpApiUrl {
    /**
     * send.
     */
    MESSAGE_TEMPLATE_SEND(WX_API_BASE_URL, "/cgi-bin/message/template/send"),
    /**
     * api_set_industry.
     */
    TEMPLATE_API_SET_INDUSTRY(WX_API_BASE_URL, "/cgi-bin/template/api_set_industry"),
    /**
     * get_industry.
     */
    TEMPLATE_GET_INDUSTRY(WX_API_BASE_URL, "/cgi-bin/template/get_industry"),
    /**
     * api_add_template.
     */
    TEMPLATE_API_ADD_TEMPLATE(WX_API_BASE_URL, "/cgi-bin/template/api_add_template"),
    /**
     * get_all_private_template.
     */
    TEMPLATE_GET_ALL_PRIVATE_TEMPLATE(WX_API_BASE_URL, "/cgi-bin/template/get_all_private_template"),
    /**
     * del_private_template.
     */
    TEMPLATE_DEL_PRIVATE_TEMPLATE(WX_API_BASE_URL, "/cgi-bin/template/del_private_template");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum UserBlacklist implements WxMpApiUrl {
    /**
     * getblacklist.
     */
    GETBLACKLIST(WX_API_BASE_URL, "/cgi-bin/tags/members/getblacklist"),
    /**
     * batchblacklist.
     */
    BATCHBLACKLIST(WX_API_BASE_URL, "/cgi-bin/tags/members/batchblacklist"),
    /**
     * batchunblacklist.
     */
    BATCHUNBLACKLIST(WX_API_BASE_URL, "/cgi-bin/tags/members/batchunblacklist");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum UserTag implements WxMpApiUrl {
    /**
     * create.
     */
    TAGS_CREATE(WX_API_BASE_URL, "/cgi-bin/tags/create"),
    /**
     * get.
     */
    TAGS_GET(WX_API_BASE_URL, "/cgi-bin/tags/get"),
    /**
     * update.
     */
    TAGS_UPDATE(WX_API_BASE_URL, "/cgi-bin/tags/update"),
    /**
     * delete.
     */
    TAGS_DELETE(WX_API_BASE_URL, "/cgi-bin/tags/delete"),
    /**
     * get.
     */
    TAG_GET(WX_API_BASE_URL, "/cgi-bin/user/tag/get"),
    /**
     * batchtagging.
     */
    TAGS_MEMBERS_BATCHTAGGING(WX_API_BASE_URL, "/cgi-bin/tags/members/batchtagging"),
    /**
     * batchuntagging.
     */
    TAGS_MEMBERS_BATCHUNTAGGING(WX_API_BASE_URL, "/cgi-bin/tags/members/batchuntagging"),
    /**
     * getidlist.
     */
    TAGS_GETIDLIST(WX_API_BASE_URL, "/cgi-bin/tags/getidlist");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Wifi implements WxMpApiUrl {
    /**
     * list.
     */
    BIZWIFI_SHOP_LIST(WX_API_BASE_URL, "/bizwifi/shop/list");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum AiOpen implements WxMpApiUrl {
    /**
     * translatecontent.
     */
    TRANSLATE_URL(WX_API_BASE_URL, "/cgi-bin/media/voice/translatecontent?lfrom=%s&lto=%s"),
    /**
     * addvoicetorecofortext.
     */
    VOICE_UPLOAD_URL(WX_API_BASE_URL, "/cgi-bin/media/voice/addvoicetorecofortext?format=%s&voice_id=%s&lang=%s"),
    /**
     * queryrecoresultfortext.
     */
    VOICE_QUERY_RESULT_URL(WX_API_BASE_URL, "/cgi-bin/media/voice/queryrecoresultfortext");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Card implements WxMpApiUrl {
    /**
     * create.
     */
    CARD_CREATE(WX_API_BASE_URL, "/card/create"),
    /**
     * get.
     */
    CARD_GET(WX_API_BASE_URL, "/card/get"),
    /**
     * wx_card.
     */
    CARD_GET_TICKET(WX_API_BASE_URL, "/cgi-bin/ticket/getticket?type=wx_card"),
    /**
     * decrypt.
     */
    CARD_CODE_DECRYPT(WX_API_BASE_URL, "/card/code/decrypt"),
    /**
     * get.
     */
    CARD_CODE_GET(WX_API_BASE_URL, "/card/code/get"),
    /**
     * consume.
     */
    CARD_CODE_CONSUME(WX_API_BASE_URL, "/card/code/consume"),
    /**
     * mark.
     */
    CARD_CODE_MARK(WX_API_BASE_URL, "/card/code/mark"),
    /**
     * set.
     */
    CARD_TEST_WHITELIST(WX_API_BASE_URL, "/card/testwhitelist/set"),
    /**
     * create.
     */
    CARD_QRCODE_CREATE(WX_API_BASE_URL, "/card/qrcode/create"),
    /**
     * create.
     */
    CARD_LANDING_PAGE_CREATE(WX_API_BASE_URL, "/card/landingpage/create"),
    /**
     * 将用户的卡券设置为失效状态.
     */
    CARD_CODE_UNAVAILABLE(WX_API_BASE_URL, "/card/code/unavailable"),
    /**
     * 卡券删除.
     */
    CARD_DELETE(WX_API_BASE_URL, "/card/delete");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum DataCube implements WxMpApiUrl {
    /**
     * getusersummary.
     */
    GET_USER_SUMMARY(WX_API_BASE_URL, "/datacube/getusersummary"),
    /**
     * getusercumulate.
     */
    GET_USER_CUMULATE(WX_API_BASE_URL, "/datacube/getusercumulate"),
    /**
     * getarticlesummary.
     */
    GET_ARTICLE_SUMMARY(WX_API_BASE_URL, "/datacube/getarticlesummary"),
    /**
     * getarticletotal.
     */
    GET_ARTICLE_TOTAL(WX_API_BASE_URL, "/datacube/getarticletotal"),
    /**
     * getuserread.
     */
    GET_USER_READ(WX_API_BASE_URL, "/datacube/getuserread"),
    /**
     * getuserreadhour.
     */
    GET_USER_READ_HOUR(WX_API_BASE_URL, "/datacube/getuserreadhour"),
    /**
     * getusershare.
     */
    GET_USER_SHARE(WX_API_BASE_URL, "/datacube/getusershare"),
    /**
     * getusersharehour.
     */
    GET_USER_SHARE_HOUR(WX_API_BASE_URL, "/datacube/getusersharehour"),
    /**
     * getupstreammsg.
     */
    GET_UPSTREAM_MSG(WX_API_BASE_URL, "/datacube/getupstreammsg"),
    /**
     * getupstreammsghour.
     */
    GET_UPSTREAM_MSG_HOUR(WX_API_BASE_URL, "/datacube/getupstreammsghour"),
    /**
     * getupstreammsgweek.
     */
    GET_UPSTREAM_MSG_WEEK(WX_API_BASE_URL, "/datacube/getupstreammsgweek"),
    /**
     * getupstreammsgmonth.
     */
    GET_UPSTREAM_MSG_MONTH(WX_API_BASE_URL, "/datacube/getupstreammsgmonth"),
    /**
     * getupstreammsgdist.
     */
    GET_UPSTREAM_MSG_DIST(WX_API_BASE_URL, "/datacube/getupstreammsgdist"),
    /**
     * getupstreammsgdistweek.
     */
    GET_UPSTREAM_MSG_DIST_WEEK(WX_API_BASE_URL, "/datacube/getupstreammsgdistweek"),
    /**
     * getupstreammsgdistmonth.
     */
    GET_UPSTREAM_MSG_DIST_MONTH(WX_API_BASE_URL, "/datacube/getupstreammsgdistmonth"),
    /**
     * getinterfacesummary.
     */
    GET_INTERFACE_SUMMARY(WX_API_BASE_URL, "/datacube/getinterfacesummary"),
    /**
     * getinterfacesummaryhour.
     */
    GET_INTERFACE_SUMMARY_HOUR(WX_API_BASE_URL, "/datacube/getinterfacesummaryhour");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Kefu implements WxMpApiUrl {
    /**
     * send.
     */
    MESSAGE_CUSTOM_SEND(WX_API_BASE_URL, "/cgi-bin/message/custom/send"),
    /**
     * getkflist.
     */
    GET_KF_LIST(WX_API_BASE_URL, "/cgi-bin/customservice/getkflist"),
    /**
     * getonlinekflist.
     */
    GET_ONLINE_KF_LIST(WX_API_BASE_URL, "/cgi-bin/customservice/getonlinekflist"),
    /**
     * add.
     */
    KFACCOUNT_ADD(WX_API_BASE_URL, "/customservice/kfaccount/add"),
    /**
     * update.
     */
    KFACCOUNT_UPDATE(WX_API_BASE_URL, "/customservice/kfaccount/update"),
    /**
     * inviteworker.
     */
    KFACCOUNT_INVITE_WORKER(WX_API_BASE_URL, "/customservice/kfaccount/inviteworker"),
    /**
     * uploadheadimg.
     */
    KFACCOUNT_UPLOAD_HEAD_IMG(WX_API_BASE_URL, "/customservice/kfaccount/uploadheadimg?kf_account=%s"),
    /**
     * del kfaccount.
     */
    KFACCOUNT_DEL(WX_API_BASE_URL, "/customservice/kfaccount/del?kf_account=%s"),
    /**
     * create.
     */
    KFSESSION_CREATE(WX_API_BASE_URL, "/customservice/kfsession/create"),
    /**
     * close.
     */
    KFSESSION_CLOSE(WX_API_BASE_URL, "/customservice/kfsession/close"),
    /**
     * getsession.
     */
    KFSESSION_GET_SESSION(WX_API_BASE_URL, "/customservice/kfsession/getsession?openid=%s"),
    /**
     * getsessionlist.
     */
    KFSESSION_GET_SESSION_LIST(WX_API_BASE_URL, "/customservice/kfsession/getsessionlist?kf_account=%s"),
    /**
     * getwaitcase.
     */
    KFSESSION_GET_WAIT_CASE(WX_API_BASE_URL, "/customservice/kfsession/getwaitcase"),
    /**
     * getmsglist.
     */
    MSG_RECORD_LIST(WX_API_BASE_URL, "/customservice/msgrecord/getmsglist"),
    /**
     * typing.
     */
    CUSTOM_TYPING(WX_API_BASE_URL, "/cgi-bin/message/custom/typing");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum MassMessage implements WxMpApiUrl {
    /**
     * 上传群发用的图文消息.
     */
    MEDIA_UPLOAD_NEWS_URL(WX_API_BASE_URL, "/cgi-bin/media/uploadnews"),
    /**
     * 上传群发用的视频.
     */
    MEDIA_UPLOAD_VIDEO_URL(WX_API_BASE_URL, "/cgi-bin/media/uploadvideo"),
    /**
     * 分组群发消息.
     */
    MESSAGE_MASS_SENDALL_URL(WX_API_BASE_URL, "/cgi-bin/message/mass/sendall"),
    /**
     * 按openId列表群发消息.
     */
    MESSAGE_MASS_SEND_URL(WX_API_BASE_URL, "/cgi-bin/message/mass/send"),
    /**
     * 群发消息预览接口.
     */
    MESSAGE_MASS_PREVIEW_URL(WX_API_BASE_URL, "/cgi-bin/message/mass/preview"),
    /**
     * 删除群发接口.
     */
    MESSAGE_MASS_DELETE_URL(WX_API_BASE_URL, "/cgi-bin/message/mass/delete");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Material implements WxMpApiUrl {
    /**
     * get.
     */
    MEDIA_GET_URL(WX_API_BASE_URL, "/cgi-bin/media/get"),
    /**
     * upload.
     */
    MEDIA_UPLOAD_URL(WX_API_BASE_URL, "/cgi-bin/media/upload?type=%s"),
    /**
     * uploadimg.
     */
    IMG_UPLOAD_URL(WX_API_BASE_URL, "/cgi-bin/media/uploadimg"),
    /**
     * add_material.
     */
    MATERIAL_ADD_URL(WX_API_BASE_URL, "/cgi-bin/material/add_material?type=%s"),
    /**
     * add_news.
     */
    NEWS_ADD_URL(WX_API_BASE_URL, "/cgi-bin/material/add_news"),
    /**
     * get_material.
     */
    MATERIAL_GET_URL(WX_API_BASE_URL, "/cgi-bin/material/get_material"),
    /**
     * update_news.
     */
    NEWS_UPDATE_URL(WX_API_BASE_URL, "/cgi-bin/material/update_news"),
    /**
     * del_material.
     */
    MATERIAL_DEL_URL(WX_API_BASE_URL, "/cgi-bin/material/del_material"),
    /**
     * get_materialcount.
     */
    MATERIAL_GET_COUNT_URL(WX_API_BASE_URL, "/cgi-bin/material/get_materialcount"),
    /**
     * batchget_material.
     */
    MATERIAL_BATCHGET_URL(WX_API_BASE_URL, "/cgi-bin/material/batchget_material");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum MemberCard implements WxMpApiUrl {
    /**
     * create.
     */
    MEMBER_CARD_CREATE(WX_API_BASE_URL, "/card/create"),
    /**
     * activate.
     */
    MEMBER_CARD_ACTIVATE(WX_API_BASE_URL, "/card/membercard/activate"),
    /**
     * get userinfo.
     */
    MEMBER_CARD_USER_INFO_GET(WX_API_BASE_URL, "/card/membercard/userinfo/get"),
    /**
     * updateuser.
     */
    MEMBER_CARD_UPDATE_USER(WX_API_BASE_URL, "/card/membercard/updateuser"),
    /**
     * 会员卡激活之微信开卡接口(wx_activate=true情况调用).
     */
    MEMBER_CARD_ACTIVATE_USER_FORM(WX_API_BASE_URL, "/card/membercard/activateuserform/set"),
    /**
     * 获取会员卡开卡插件参数.
     */
    MEMBER_CARD_ACTIVATE_URL(WX_API_BASE_URL, "/card/membercard/activate/geturl"),
    /**
     * 会员卡信息更新.
     */
    MEMBER_CARD_UPDATE(WX_API_BASE_URL, "/card/update"),
    /**
     * 跳转型会员卡开卡字段.
     * 获取用户提交资料(wx_activate=true情况调用),开发者根据activate_ticket获取到用户填写的信息
     */
    MEMBER_CARD_ACTIVATE_TEMP_INFO(WX_API_BASE_URL, "/card/membercard/activatetempinfo/get");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }

  @AllArgsConstructor
  enum Store implements WxMpApiUrl {
    /**
     * getwxcategory.
     */
    POI_GET_WX_CATEGORY_URL(WX_API_BASE_URL, "/cgi-bin/poi/getwxcategory"),
    /**
     * updatepoi.
     */
    POI_UPDATE_URL(WX_API_BASE_URL, "/cgi-bin/poi/updatepoi"),
    /**
     * getpoilist.
     */
    POI_LIST_URL(WX_API_BASE_URL, "/cgi-bin/poi/getpoilist"),
    /**
     * delpoi.
     */
    POI_DEL_URL(WX_API_BASE_URL, "/cgi-bin/poi/delpoi"),
    /**
     * getpoi.
     */
    POI_GET_URL(WX_API_BASE_URL, "/cgi-bin/poi/getpoi"),
    /**
     * addpoi.
     */
    POI_ADD_URL(WX_API_BASE_URL, "/cgi-bin/poi/addpoi");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }


  @AllArgsConstructor
  enum User implements WxMpApiUrl {
    /**
     * batchget.
     */
    USER_INFO_BATCH_GET_URL(WX_API_BASE_URL, "/cgi-bin/user/info/batchget"),
    /**
     * get.
     */
    USER_GET_URL(WX_API_BASE_URL, "/cgi-bin/user/get"),
    /**
     * info.
     */
    USER_INFO_URL(WX_API_BASE_URL, "/cgi-bin/user/info"),
    /**
     * updateremark.
     */
    USER_INFO_UPDATE_REMARK_URL(WX_API_BASE_URL, "/cgi-bin/user/info/updateremark"),
    /**
     * changeopenid.
     */
    USER_CHANGE_OPENID_URL(WX_API_BASE_URL, "/cgi-bin/changeopenid");

    private String prefix;
    private String path;

    @Override
    public String getUrl() {
      return this.prefix + this.path;
    }
  }
}
