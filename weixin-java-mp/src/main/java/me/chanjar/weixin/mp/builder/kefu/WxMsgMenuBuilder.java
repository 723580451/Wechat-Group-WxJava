package me.chanjar.weixin.mp.builder.kefu;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

/**
 * 卡券消息builder
 * <pre>
 * 用法: WxMpKefuMessage m = WxMpKefuMessage.WXCARD().cardId(...).toUser(...).build();
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public final class WxMsgMenuBuilder extends BaseBuilder<WxMsgMenuBuilder> {
  private String headContent;
  private String tailContent;
  private String[] msgMenuList;

  public WxMsgMenuBuilder() {
    this.msgType = WxConsts.KefuMsgType.MSGMENU;
  }

  @Override
  public WxMpKefuMessage build() {
    WxMpKefuMessage m = super.build();
    m.setHeadContent(this.headContent);
    m.setMsgMenuList(this.msgMenuList);
    m.setTailContent(this.tailContent);
    return m;
  }

  public WxMsgMenuBuilder headContent(String headContent) {
    this.headContent = headContent;
    return this;
  }

  public WxMsgMenuBuilder tailContent(String tailContent) {
    this.tailContent = tailContent;
    return this;
  }

  public WxMsgMenuBuilder msgMenuList(String... msgMenuList) {
    this.msgMenuList = msgMenuList;
    return this;
  }
}
