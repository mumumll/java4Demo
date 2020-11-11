package testNG;

import org.testng.annotations.*;

/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/1117:42
 */
public class TestNGLifeSon extends TestNGLife{
    @BeforeSuite
    public void beforSuiteSon(){
        System.out.println("beforSuite son");
    }
    @AfterSuite
    public void afterSuiteSon(){
        System.out.println("afterSuite son");
    }
    @BeforeTest
    public void beforTestSon(){
        System.out.println("beforTest son");
    }
    @AfterTest
    public void afterTestSon(){
        System.out.println("afterTest son");
    }
    @BeforeClass
    public void beforeClassSon(){
        System.out.println("beforeClass son");
    }
    @AfterClass
    public void afterClassSon(){
        System.out.println("afterClass son");
    }
    @BeforeMethod
    public void beforeMethodSon(){
        System.out.println("beforeMethod son");
    }
    @AfterMethod
    public void afterMethodSon(){
        System.out.println("afterMethod son");
    }
    @Test
    public void test01Son(){
        System.out.println("test01 son");
    }
    @Test
    public void test02Son(){
        System.out.println("test02 son");
    }
}
