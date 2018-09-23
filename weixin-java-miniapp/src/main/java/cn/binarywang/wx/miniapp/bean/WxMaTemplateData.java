package cn.binarywang.wx.miniapp.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 *
 * Created by Binary Wang on 2018/9/23.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
@NoArgsConstructor
public class WxMaTemplateData {
  private String name;
  private String value;
  private String color;

  public WxMaTemplateData(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public WxMaTemplateData(String name, String value, String color) {
    this.name = name;
    this.value = value;
    this.color = color;
  }

}
