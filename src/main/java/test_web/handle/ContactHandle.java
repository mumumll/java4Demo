package test_web.handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /**
     * 点击通讯录
     */
    public void clickMenuContacts(){
        System.out.println("点击通讯录");
        contactPage.getMenuContacts().click();
    }

    /**
     * 点击添加成员
     */
    public void clickAddMember(){
        System.out.println("点击添加成员");
        contactPage.getAddMember().click();
    }

    /**
     * 输入成员姓名
     * @param username
     */
    public void sendUername( String username){
        System.out.println("输入成员" + username);
        WebElement usernameElement = contactPage.getUernameElement();
//        ClearText(usernameElement);
        usernameElement.sendKeys(username);
    }

    /**
     * 输入部门号
     * @param acctid
     */
    public void sendAcctid(String acctid){
        System.out.println("输入部门号" + acctid);
        WebElement acctidElement = contactPage.getAcctidElement();
//        ClearText(acctidElement);
        acctidElement.sendKeys(acctid);
    }

    public void sendMobile(String mobile){
        System.out.println("输入手机号" + mobile);
        WebElement mobileElement = contactPage.getMobileElement();
//        ClearText(mobileElement);
        mobileElement.sendKeys(mobile);
    }
}
