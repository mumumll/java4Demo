package test_web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author mumu
 * @Description: 企业微信cookies登录
 * @date 2020/11/13 16:09
 */
public class WinxinLoginTest extends BaseTest{

    @Test
    void login() throws IOException {
        // 隐士等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // 打开企业微信扫码页面
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        sleep(10000);
        Set cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);

    }

    /**
     * 设置强制等待时间
     */
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
