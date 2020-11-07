package junit5;

import org.junit.jupiter.api.*;

public class Junit5Test {

    @BeforeAll
    public static void befter(){
        System.out.println("befter");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
    @Test
    @Disabled
    void test01(){
        System.out.println("this is test01");
    }
    @Test
    void test02(){
        System.out.println("this is test02");
    }

    @AfterAll
    public static void after(){
        System.out.println("after");
    }

}
