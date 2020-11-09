package junit5;

import org.junit.jupiter.api.*;

public class Junit5TestSon extends Junit5Test {

    @BeforeAll
    public static void befterSon(){
        System.out.println("befter Son");
    }
    @BeforeEach
    public void beforeEachSon(){
        System.out.println("beforeEach Son");
    }
    @AfterEach
    public void afterEachSon(){
        System.out.println("afterEach Son");
    }
    @Test
    @Disabled
    void test01Son(){
        System.out.println("this is test01 Son");
    }
    @Test
    @RepeatedTest(10)
    void test02Son(){
        System.out.println("this is test02 Son");
    }

    @AfterAll
    public static void afterSon(){
        System.out.println("after Son");
    }

}
