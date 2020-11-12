package test_web;/**
 * @program: junit4TestDemo
 * @description: 测试多浏览器
 * @author: mumu
 * @create: 2020-11-10 23:58
 **/

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @program: junit4TestDemo
 *
 * @description: 启动多浏览器
 *
 * @author: mumu
 *
 * @create: 2020-11-10 23:58
 **/
public class BrowserTest extends BaseTest{


    /**
     * 测试启动浏览器
     */
    @Test
    public void driverTest(){
      /*  String str = this.getClass().getResource("/chromedriver.exe").getPath();
        System.out.println(str);
        System.setProperty("webdriver.chrome.driver",str);

        WebDriver driver = new ChromeDriver();*/
        driver.get("https://www.baidu.com/");
    }
}
