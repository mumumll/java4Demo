package test_web.teatCase;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.handle.ContactHandle;

import java.io.IOException;

/**
 * @program: junit4TestDemo
 * @description: 通讯录相关测试用例
 * @author: mumu
 * @create: 2020-11-15 15:04
 **/
public class ContactCase extends BaseCase{
   public static ContactHandle contactHandle;
  @BeforeAll
  static void BeforeAll()  throws IOException{
      contactHandle = new ContactHandle(driver);
      // 获取登录信息
      contactHandle.setUserCookie();
      // 点击通讯录
      contactHandle.clickMenuContacts();
  }
    @Test
    @Story("添加联系人")
    void addMemberTest(){

        contactHandle.clickAddMember();
        contactHandle.sendUername("mumu01");
        contactHandle.sendAcctid("mumu001");
        contactHandle.sendMobile("18989898888");
        contactHandle.clickBtnSave();
    }
    @Test
    @Story("搜索联系人并删除")
    void searchInput(){
      contactHandle.sendSearchMemter("mumu01");
      // 点击删除按钮
      contactHandle.clickdelMemter();
      // 确认删除
        contactHandle.clickBtnDelSubmit();
    }

    @Test
    @Story("添加部门")
    void addDepartmentTest(){
      contactHandle.clickBtnTopAdd();
      contactHandle.clickAddDepartment();
      contactHandle.sendDepartName("测试部门1");
      contactHandle.clickSearchDepart();
      contactHandle.clickDepartNameList();
      contactHandle.clickBtnAddDepart();
    }
}
