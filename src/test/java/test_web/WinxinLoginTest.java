package test_web;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author mumu
 * @Description: 企业微信cookies登录
 * @date 2020/11/13 16:09
 */
public class WinxinLoginTest extends BaseTest {
    /**
     * 登录企业微信
     */
    @BeforeAll
    static void login() throws IOException {
        File file = new File("cookies.yaml");
        if (file.exists()) {
            // 复用cookies
            loginedTest();
        } else {
            // 扫码登录
            loginTest();
        }
    }

    /**
     * 添加成员
     */
    @Test
    void contackAdd() {
        System.out.println("添加成员");
    }

    /**
     * 扫码登录获取cookies
     *
     * @throws IOException
     */
    static void loginTest() throws IOException {

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
     * 获取已经登录的cookies
     *
     * @throws IOException
     */
    static void loginedTest() throws IOException {

        // 隐士等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // 打开企业微信扫码页面
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(new File("cookies.yaml"), typeReference);
        System.out.println(cookies);
        cookies.forEach(cookieMap -> {
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });
        // 刷新浏览器
        driver.navigate().refresh();
    }


}