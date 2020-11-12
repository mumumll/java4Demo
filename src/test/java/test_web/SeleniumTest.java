package test_web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/1116:57
 */
public class SeleniumTest extends BaseTest{
    /**
     * 测试chrome驱动
     */
    @Test
    public void chromeDriverTest(){
        driver.get("https://www.baidu.com/");
    }

}
