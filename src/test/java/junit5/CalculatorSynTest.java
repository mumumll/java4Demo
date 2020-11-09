package junit5;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/920:08
 */
public class CalculatorSynTest {

    @Test
    @RepeatedTest(10)
    public void countTest() {
        int result = Calculator.count(3);
//        Assert.assertEquals(5,result);
        System.out.println("统计：" + result);
    }

    @Test
    @RepeatedTest(10)
    public void synCountTest() {
        int result = Calculator.synCount(1);
//        Assert.assertEquals(1,result);
        System.out.println("安全统计：" + result);
    }

}