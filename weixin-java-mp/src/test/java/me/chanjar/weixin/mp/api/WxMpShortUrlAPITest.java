package me.chanjar.weixin.mp.api;

import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.test.ApiTestModule;
import org.testng.*;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 测试短连接
 *
 * @author chanjarster
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMpShortUrlAPITest {
  @Inject
  protected WxMpService wxService;

  public void testShortUrl() throws WxErrorException {
    String shortUrl = this.wxService.shortUrl("http://www.baidu.com/test?access_token=123");
    assertThat(shortUrl).isNotEmpty();
    System.out.println(shortUrl);
  }

  @Test(expectedExceptions = WxErrorException.class)
  public void testShortUrl_with_exceptional_url() throws WxErrorException {
    this.wxService.shortUrl("http://www.baidu.com/test?redirect_count=1&access_token=123");
  }

}
