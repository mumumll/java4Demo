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
 * @description: 测试多浏览器
 *
 * @author: mumu
 *
 * @create: 2020-11-10 23:58
 **/
public class BrowserTest extends BaseTest{


    @Test
    public void browserTest(){
        driver.get("https://ceshiren.com/t/topic/7718/21");
    }
}
