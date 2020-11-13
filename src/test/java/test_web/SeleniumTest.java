package test_web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author mumu
 * @Description: selenium常用操作练习
 * @date 2020/11/13 16:09
 */
public class SeleniumTest extends BaseTest{
    @Test
    public void chromeDriverTest(){
        driver.get("https://www.baidu.com/");
    }

}
