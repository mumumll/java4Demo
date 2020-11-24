package test_web.handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    /**
     * 清空输入框
     * @param element
     */
    public void ClearText(WebElement element){
        element.clear();
    }
    /**
     * 点击操作
     * @param by
     */
    void click(By by) {
        driver.findElement(by).click();
    }

    /**
     * 查找元素，设置值
     * @param by
     * @param content
     */
    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }
}
