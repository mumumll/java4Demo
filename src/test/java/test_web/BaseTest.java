package test_web;/**
 * @program: junit4TestDemo
 * @description: 支持浏览器驱动
 * @author: mumu
 * @create: 2020-11-10 23:38
 **/

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @program: junit4TestDemo
 *
 * @description: 支持浏览器处理
 *
 * @author: mumu
 *
 * @create: 2020-11-10 23:38
 **/
public class BaseTest {
    public static WebDriver driver;
    @BeforeAll
    public static void initData(){
        String browserName = System.getenv("browser");
        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","D:/software/chromedriver_win32/chromedriver");
            driver = new ChromeDriver();
        }else if("edge".equals(browserName)){
            System.setProperty("webdriver.edge.driver","D:/software/chromedriver_win32/chromedriver");
            driver = new FirefoxDriver();
        }else if("firefox".equals(browserName)){
            System.setProperty("webdriver.gecko.driver","D:/software/chromedriver_win32/chromedriver");
            driver = new FirefoxDriver();
        }
    }
    @AfterAll
    public static void quit(){
        driver.quit();

    }

}
