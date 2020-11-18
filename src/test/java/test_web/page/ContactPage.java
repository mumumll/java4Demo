package test_web.page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @program: junit4TestDemo
 * @description: 获取通讯录页面元素
 * @author: mumu
 * @create: 2020-11-15 14:53
 **/
public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver){
        super(driver);
    }

    /**
     * 获取联系人姓名元素
     */
    @Test
    public WebElement getUernameElement(){
        return getElement("username");
    }
    /**
     * 获取部门号元素
     */
    public WebElement getAcctidElement(){
        return getElement("acctid");
    }
    /**
     * 获取联系人手机元素
     */
    public WebElement getMobileElement(){
        return getElement("mobile");
    }
}
