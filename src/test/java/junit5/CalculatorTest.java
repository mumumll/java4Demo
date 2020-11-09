package junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 按顺序执行测试类
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
    @Test
    @Order(1)
    void addTest() {
        final int result1 = Calculator.add(3,7);
        System.out.println("加法：" + result1);

        int result2 = Calculator.add(1,7);
        System.out.println("加法：" + result2);
        int result3 = Calculator.add(2,7);
        System.out.println("加法：" + result3);

        assertAll(
                "加法计算结果：",
                () ->assertEquals(10,result1),
                () ->assertEquals(10,result2),
                () ->assertEquals(10,result3)
        );

    }

    @Test
    @Order(2)
    void subtractTest() {
        int result = Calculator.subtract(7,3);
        System.out.println("减法：" + result);
    }

    @Test
    @Order(3)
    void multiplyTest() {
        int result = Calculator.multiply(3,7);
        System.out.println("乘法：" + result);
    }

    @Test
    @Order(4)
    void divideTest() {
        int result = Calculator.divide(8,2);
        System.out.println("除法：" + result);
    }

    @Test
    @Order(5)
    void countTest() {
        int result = Calculator.count(3);
        result = Calculator.count(1);
        result = Calculator.count(1);
        System.out.println("统计：" + result);
    }
    @BeforeEach
    void clearTest(){
        Calculator.clear();
    }
}