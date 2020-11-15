package test_web.teatCase;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_web.page.MainPage;

import java.io.IOException;

/**
 * @program: junit4TestDemo
 * @description: 通讯录相关测试用例
 * @author: mumu
 * @create: 2020-11-15 15:04
 **/
public class ContactTest {
    private static MainPage main;
    @BeforeAll
    static void beforAll() throws IOException {
        main = new MainPage();
    }
    @Test
    @Story("添加联系人")
    void addMemberTest(){

    }
}
