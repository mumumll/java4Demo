package test_web.handle;

import org.openqa.selenium.WebDriver;

/**
 * @author mumu
 * @Description: 输入基类
 * @date 2020/11/18 14:44
 */
public class BaseHandle {
    public WebDriver driver;
    public BaseHandle(WebDriver driver) {
        this.driver = driver;
    }
}
