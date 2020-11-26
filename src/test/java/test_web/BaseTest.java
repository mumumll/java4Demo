package test_web;/**
 * @program: junit4TestDemo
 * @description: 支持浏览器驱动
 * @author: mumu
 * @create: 2020-11-10 23:38
 **/

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @program: junit4TestDemo
 *
 * @description: 支持多浏览器处理
 *
 * @author: mumu
 *
 * @create: 2020-11-10 23:38
 **/
public class BaseTest {
    public static WebDriver driver;
    public static String browserName = "chrome";
    // 获取浏览器驱动路径

    @BeforeAll
    public static void initData(){

        if("chrome".equals(browserName)){
//            System.setProperty("webdriver.chrome.driver",chromeDriver);
            driver = new ChromeDriver();
        }else if("edge".equals(browserName)){
//            System.setProperty("webdriver.edge.driver",geckodDriver);
            driver = new EdgeDriver();
        }else if("firefox".equals(browserName)){
//            System.setProperty("webdriver.gecko.driver",msedgeDriver);
            driver = new FirefoxDriver();
        }
    }
 /*   @AfterAll
    public static void quit(){
        sleep(10000);
        driver.quit();

    }*/

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
