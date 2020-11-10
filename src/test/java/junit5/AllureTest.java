package junit5;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Epic("Epic 计算器项目")
@Feature("Feature 冒烟测试用例")
class AllureTest {

    @Test
    @Description("Description 这是一个计算器的加法")
    @Story("Story 加法测试")
    @DisplayName("DisplayName 加法测试")
    @Issue("https://docs.qameta.io/allure/")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "测试社区",type = "mylink",url = "https://ceshiren.com/t/topic/7718")
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
    @Description("Description 这是一个计算器的减法")
    @Story("Story 减法测试")
    @DisplayName("DisplayName 减法测试")
    @Issue("https://docs.qameta.io/allure/")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "测试社区",type = "mylink",url = "https://ceshiren.com/t/topic/7718")
    void subtractTest() {
        int result = Calculator.subtract(7,3);
        System.out.println("减法：" + result);
        Allure.addAttachment("pic","image/png",this.getClass().getResourceAsStream("/erha.png"),".png");
    }

    @Test
    @Description("Description 这是一个计算器的乘法")
    @Story("Story 乘法测试")
    @DisplayName("DisplayName 乘法测试")
    @Issue("https://docs.qameta.io/allure/")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "测试社区",type = "mylink",url = "https://ceshiren.com/t/topic/7718")
    void multiplyTest() {
        int result = Calculator.multiply(3,7);
        System.out.println("乘法：" + result);
    }

    @Test
    @Description("Description 这是一个计算器的除法")
    @Story("Story 除法测试")
    @DisplayName("DisplayName 除法测试")
    @Issue("https://docs.qameta.io/allure/")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "测试社区",type = "mylink",url = "https://ceshiren.com/t/topic/7718")
    void divideTest() {
        int result = Calculator.divide(8,2);
        System.out.println("除法：" + result);
    }

    @Test
    @Description("Description 这是一个计算器的计数器")
    @Story("Story 计数器测试")
    @DisplayName("DisplayName 计数器测试")
    @Issue("https://docs.qameta.io/allure/")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "测试社区",type = "mylink",url = "https://ceshiren.com/t/topic/7718")
    void countTest() {
        int result = Calculator.count(3);
        result = Calculator.count(1);
        result = Calculator.count(1);
        System.out.println("统计：" + result);
    }
    @BeforeEach
    void clearTest(){
        Calculator.clear();
        System.out.println("clear");
    }
}