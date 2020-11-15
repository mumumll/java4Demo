package test_web.page;

import org.openqa.selenium.WebDriver;

/**
 * @program: junit4TestDemo
 * @description: 通讯录页面操作PO
 * @author: mumu
 * @create: 2020-11-15 14:53
 **/
public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver){
        super(driver);
    }

    /**
     * 添加联系人操作
     */
    public ContactPage addMember(String usename,String acctid,String mobile){
        return this;
    }
}
