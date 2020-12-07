package test_web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @program: junit4TestDemo
 * @description: 获取通讯录添加、搜索页面元素
 * @author: mumu
 * @create: 2020-11-15 14:53
 **/
public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver){
        super(driver);
    }

    /**
     * 获取通讯录元素
     * @return
     */
    public WebElement getMenuContacts(){
        return getElement("menucontacts");
    }

    /**
     * 获取添加成员元素
     * @return
     */
    public WebElement getAddMember(){
        return getElement("add_memter");
    }
    /**
     * 获取联系人姓名元素
     */
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

    /**
     * 获取保存按钮元素
     * @return
     */
    public WebElement getBtnSave() {
        return getElement("btnsave");
    }

    /**
     * 获取搜索成员输入框元素
     * @return
     */
    public WebElement getSearchMemter(){
        return getElement("search_member");
    }

    /**
     * 获取删除成员元素
     * @return
     */
    public WebElement getDelMemter(){
        return getElement("del_member");
    }

    /**
     * 获取确认删除按钮元素
     * @return
     */
    public WebElement getBtnDelSubmit(){
        return getElement("btndelsubmit");
    }

    /**
     * 获取添加按钮元素
     * @return
     */
    public WebElement getBtnTopAdd(){
        return getElement("btntop_add");
    }

    /**
     * 获取添加部门按钮元素
     * @return
     */
    public WebElement getAddDepartment(){
        return getElement("add_department");
    }

    /**
     * 获取部门名称元素
     * @return
     */
    public WebElement getDepartName(){
        return getElement("depart_name");
    }

    /**
     * 获取选择所属部门按钮元素
     * @return
     */
    public WebElement getSearchDepart(){
        return getElement("search_depart");
    }

    /**
     * 获取部门按钮元素
     * @return
     */
    public WebElement getDepartNameList(){
        return getElement("depart_name_list");

    }

    /**
     * 获取添加部门确认按钮元素
     * @return
     */
    public WebElement getBtnAddDepart(){
        return getElement("btnadddepart");
    }
}
