package test_web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test_web.util.ProUtil;

/**
 * @program: junit4TestDemo
 * @description: 基本操作PO
 * @author: mumu
 * @create: 2020-11-15 14:49
 **/
public class BasePage {
    public static WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
    /**
     * 获取元素
     * @param key
     * @return
     */
    public WebElement getElement(String key) {
        boolean flag=true;
        int i =0;
        WebElement Element=null;
        while(flag) {
            try {
                Element = driver.findElement(this.getByLocal(key));
                flag=false;

            }
            catch(Exception e) {
                i=i+1;
                if(i ==10) {
                    flag=false;
                }
            }
        }
        return Element;
    }

    /**
     *
     * @param key
     * @return
     */
    public By getByLocal(String key) {
//        key = "username";

        // 获取元素文件
//        ProUtil pro = new ProUtil("E:\\muke\\java4Demo\\src\\main\\resources\\element.properties");
        ProUtil pro = new ProUtil("H:\\IdeaSpace\\xunitTestDemo\\java4Demo\\src\\main\\resources\\element.properties");
        System.out.println(pro);
        String Locator = pro.GetPro(key); //username=name>email
        System.out.println("获取的元素：" + Locator);
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        if(LocatorBy.equals("id")) {
            return By.id(LocatorValue);
        }else if(LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        }else if(LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        }else if(LocatorBy.equals("linkText")) {
            return By.linkText(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }
    /**
     * 点击操作
     * @param by
     */
    void click(By by) {
        driver.findElement(by).click();
    }

  /*  *//**
     * 查找元素，设置值
     * @param by
     * @param content
     *//*
    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }*/


}
