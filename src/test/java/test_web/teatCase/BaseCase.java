package test_web.teatCase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: junit4TestDemo
 * @description:
 * @author: mumu
 * @create: 2020-12-02 21:31
 **/
public class BaseCase {
    public static WebDriver driver;
    public static String browserName = "chrome";
    @BeforeAll
    public static void initData() throws IOException {

        if("chrome".equals(browserName)){
            driver = new ChromeDriver();
        }else if("edge".equals(browserName)){
            driver = new EdgeDriver();
        }else if("firefox".equals(browserName)){
            driver = new FirefoxDriver();
        }

       /* File file = new File("cookies.yaml");
        if (file.exists()) {
            loginedTest();
        } else {
            loginTest();
        }*/

    }

    /**
     * 扫码登录获取cookies
     *
     * @throws IOException
     */
    static void loginTest () throws IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //sleep 20
        sleep(15000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
        System.exit(0);

    }


    /**
     * 获取已经登录的cookies
     *
     * @throws IOException
     */
    static void loginedTest () throws IOException {
        File file = new File("cookies.yaml");
        // 隐士等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // 打开企业微信扫码页面
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };

        List<HashMap<String, Object>> cookies = mapper.readValue(file, typeReference);
        System.out.println(cookies);

        cookies.forEach(cookieMap -> {
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
        });
        // 刷新浏览器
        driver.navigate().refresh();
        // 窗口最大化
        driver.manage().window().maximize();
    }
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
