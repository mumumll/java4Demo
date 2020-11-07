package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
//    Calculator calculator = new Calculator();
    @Test
    void add() {
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
    void subtract() {
        int result = Calculator.subtract(7,3);
        System.out.println("减法：" + result);
    }

    @Test
    void multiply() {
        int result = Calculator.multiply(3,7);
        System.out.println("乘法：" + result);
    }

    @Test
    void divide() {
        int result = Calculator.divide(8,2);
        System.out.println("除法：" + result);
    }

    @Test
    void count() {
        int result = Calculator.count(3);
        result = Calculator.count(1);
        result = Calculator.count(1);
        System.out.println("统计：" + result);
    }
}