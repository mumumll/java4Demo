package junit5;


import org.junit.jupiter.api.RepeatedTest;


/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/920:08
 */
public class CalculatorSynTest {

    @RepeatedTest(10)
    public void countTest() {
        int result = Calculator.count(3);
//        Assert.assertEquals(5,result);
        System.out.println("统计：" + result);
    }

    @RepeatedTest(10)
    public void synCountTest() {
        int result = Calculator.synCount(1);
//        Assert.assertEquals(1,result);
        System.out.println("安全统计：" + result);
    }

}