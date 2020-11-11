package testNG;

import org.testng.annotations.*;

/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/1117:42
 */
public class TestNGLife {
    @BeforeSuite
    public void beforSuite(){
        System.out.println("beforSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
    @BeforeTest
    public void beforTest(){
        System.out.println("beforTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @Test(enabled = false)
    public void test01(){
        System.out.println("test01");
    }
    @Test
    public void test02(){
        System.out.println("test02");
    }
}
