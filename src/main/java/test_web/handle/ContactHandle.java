package test_web.handle;

import org.openqa.selenium.WebDriver;
import test_web.page.ContactPage;

/**
 * @author mumu
 * @Description: 输入通讯录页面元素
 * @date 2020/11/18 14:40
 */
public class ContactHandle extends BaseHandle{
    public ContactPage contactPage;
    public ContactHandle(WebDriver driver) {
        super(driver);
        contactPage = new ContactPage(driver);
    }
}
