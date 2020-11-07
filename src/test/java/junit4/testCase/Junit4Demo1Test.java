package junit4.testCase;


import org.junit.*;

public class Junit4Demo1Test {
    @BeforeClass
    public static void beforClassTest(){
        System.out.println("this beforClass Test");
    }
    @Before
    public void afterTest(){
        System.out.println("this before Test");
    }
    @After
    public void beforTest(){
        System.out.println("this after Test");
    }

    @Test
    public void fun1(){
        System.out.println("this fun1 test");
    }
    @Test
    public void fun2(){
        System.out.println("this fun2 test");
    }
    @Test
    @Ignore
    public void fun3(){
        System.out.println("this fun3 test");
    }
    @AfterClass
    public static void afterClassTest(){
        System.out.println("this afterClass Test");
    }

}
