package junit5;


import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mumu
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2020/11/920:47
 */
public class CalculatorThreadTest {
    @RepeatedTest(10)
    public void addTest(){
        int result = Calculator.add(3,2);
        System.out.println(result);
        assertEquals(5,result);
    }
    @RepeatedTest(10)
    public void subTractTest(){
        int result = Calculator.subtract(4,2);
        System.out.println(result);
        assertEquals(2,result);
    }

}