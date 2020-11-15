package test_web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @program: junit4TestDemo
 * @description: 基本操作PO
 * @author: mumu
 * @create: 2020-11-15 14:49
 **/
public class BasePage {
    WebDriver driver = new ChromeDriver();
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
    public BasePage(){

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
