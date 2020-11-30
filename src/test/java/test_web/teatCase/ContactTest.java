package test_web.teatCase;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.handle.ContactHandle;

/**
 * @program: junit4TestDemo
 * @description: 通讯录相关测试用例
 * @author: mumu
 * @create: 2020-11-15 15:04
 **/
public class ContactTest extends BaseCase{
//    private static MainPage main;
   public static ContactHandle contactHandle;
  /*  @BeforeAll
    public static void beforAll() throws IOException {
        main = new MainPage();
        contactHandle =new ContactHandle(BaseCase.driver);
    }*/
  @BeforeAll
  static void BeforeAll(){
      contactHandle = new ContactHandle(driver);
  }
    @Test
    @Story("添加联系人")
    void addMemberTest(){
        contactHandle.clickMenuContacts();
        contactHandle.clickAddMember();
        contactHandle.sendUername("mumu01");
        contactHandle.sendAcctid("mumu001");
        contactHandle.sendMobile("18989898888");

    }
}
