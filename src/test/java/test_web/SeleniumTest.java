package test_web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.server.HttpChannelState;

import java.util.concurrent.TimeUnit;

/**
 * @author mumu
 * @Description: selenium常用操作练习
 * @date 2020/11/13 16:09
 */
public class SeleniumTest extends BaseTest{
    Actions actions = new Actions(driver) ;

    /**
     * selenium 元素定位和登录ceshiren网站
     */
    @Test
    void loginTest(){
        // 隐士等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // 打开网页
        driver.get("https://ceshiren.com");
        // 窗口最大化
        driver.manage().window().maximize();
        // 找到登录按钮，并点击登录
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        // 输入用户名
        driver.findElement(By.id("login-account-name")).sendKeys("1270102724@qq.com");
        // 输入密码
        driver.findElement(By.id("login-account-password")).sendKeys("19921007mll");
        // 点击登录
        driver.findElement(By.id("login-button")).click();
        // 刷新页面
        driver.navigate().refresh();
    }
    /**
     * Action 用法，元素点击
     */
    @Test
    void clickTest(){
//        Actions actions = new Actions(driver);
        driver.get("http://sahitest.com/demo/clicks.htm");
        // 单击
        WebElement click = driver.findElement(By.xpath("//input[@value='click me']"));
        actions.click(click);
        // 双击
        WebElement dbClick = driver.findElement(By.xpath("//input[@ondblclick='dcl(event)']"));
        actions.doubleClick(dbClick);
        // 右键点击
        WebElement rightClick = driver.findElement(By.xpath("//input[@oncontextmenu='rcl(event)']"));
        actions.contextClick(rightClick);
        // 执行上述操作
        actions.perform();

        sleep(10000);
    }
    /**
     * Action 用法，鼠标移动
     */
    @Test
    void mouseMoveTest(){
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        // 移动鼠标到指定位置
       WebElement shezhi = driver.findElement(By.name("tj_settingicon"));
       actions.moveToElement(shezhi);
       actions.perform();
    }

    /**
     * Action用法，拖动一个元素到另一个元素上
     */
    @Test
    void dropTest(){
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        // 要拖动的元素
        WebElement source = driver.findElement(By.id("dragger"));
        // 拖动的目标元素
        WebElement target1 = driver.findElement(By.xpath("//div[contains(text(),'Item 1')]"));
        WebElement target2 = driver.findElement(By.xpath("//div[contains(text(),'Item 2')]"));
        // 拖动source到target
//        actions.dragAndDrop(source,target1);
        actions.dragAndDrop(source,target2);
        actions.perform();

    }

    /**
     * Action用法，复制粘贴
     */
    @Test
    void labelTest(){
        driver.get("http://sahitest.com/demo/label.htm");
    }


}
