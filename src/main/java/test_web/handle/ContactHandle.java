package test_web.handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test_web.page.ContactPage;

/**
 * @author mumu
 * @Description: 输入通讯录添加、搜索页面元素
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

    /**
     * 输入手机号
     * @param mobile
     */
    public void sendMobile(String mobile){
        System.out.println("输入手机号" + mobile);
        WebElement mobileElement = contactPage.getMobileElement();
//        ClearText(mobileElement);
        mobileElement.sendKeys(mobile);
    }

    /**
     * 点击保存按钮
     */
    public void clickBtnSave(){
        System.out.println("点击保存");
        contactPage.getBtnSave().click();
    }

    /**
     * 输入搜索内容
     * @param searchMemter
     */
    public void sendSearchMemter(String searchMemter){
        System.out.println("输入搜索内容" + searchMemter);
        WebElement searchMemterElement = contactPage.getSearchMemter();
        searchMemterElement.click();
        searchMemterElement.sendKeys(searchMemter);
    }

    /**
     * 点击删除成员
     *
     */
    public void clickdelMemter(){
        System.out.println("点击删除成员");
        sleep(3000);
        contactPage.getDelMemter().click();

    }
    /**
     * 点击确认删除
     */
    public void clickBtnDelSubmit(){
        sleep(3000);
        contactPage.getBtnDelSubmit().click();
    }

    /**
     * 点击添加
     */
    public void clickBtnTopAdd(){
        sleep(3000);
        contactPage.getBtnTopAdd().click();
    }

    /**
     * 点击添加部门
     */
    public void clickAddDepartment(){
        contactPage.getAddDepartment().click();
    }

    public void sendDepartName(String departName){
        System.out.println("输入部门名称" + departName);
        WebElement departNameElement = contactPage.getDepartName();
//        ClearText(mobileElement);
        departNameElement.sendKeys(departName);
    }
    /**
     * 点击选择所属部门
     */
    public void clickSearchDepart(){
        System.out.println("选择所属部门");
        contactPage.getSearchDepart().click();
    }

    /**
     * 点击要添加的部门
     */
    public void clickDepartNameList(){
        sleep(3000);
//        contactPage.getDepartNameList().click();
        driver.findElements(By.linkText("木木网络有限公司")).get(1).click();
    }

    /**
     * 点击添加部门确定
     */
    public void clickBtnAddDepart(){
        System.out.println("确定添加部门");
        sleep(3000);
        contactPage.getBtnAddDepart().click();
    }
}
