package test_web.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: junit4TestDemo
 * @description: 初始化操作,登录企业微信
 * @author: mumu
 * @create: 2020-11-15 14:49
 **/
public class MainPage extends BasePage{
//    WebDriver driver = new ChromeDriver();
    public MainPage() throws IOException {
        this.login();
    }
    public ContactPage contact(){
        //进入通讯录
        click(By.id("menu_contacts"));
        //传递selenium的driver给另外一个PO
        return new ContactPage(driver);
    }

    /**
     * 登录企业微信
     * @throws IOException
     */
    void login() throws IOException {
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
     * 扫码登录获取cookies
     *
     * @throws IOException
     */
    void loginTest() throws IOException {

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
   void loginedTest() throws IOException {

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
    /**
     * 设置强制等待时间
     */
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
