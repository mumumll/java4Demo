package junit4.suiteDemo;

import junit4.testCase.BuyTest;
import junit4.testCase.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        BuyTest.class
})
public class SuiteTest {

}
