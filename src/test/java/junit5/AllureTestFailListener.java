package junit5;/**
 * @program: junit4TestDemo
 * @description: 用例执行失败截图类
 * @author: mumu
 * @create: 2020-11-10 00:07
 **/


/**
 * @program: junit4TestDemo
 *
 * @description: 用例执行失败截图类
 *
 * @author: mumu
 *
 * @create: 2020-11-10 00:07
 **/
public class AllureTestFailListener {
    /**
     * 用例失败
     * @param
     */
    public void onTestFailure() {
       /* System.out.println("*** 测试执行 " + result.getMethod().getMethodName() + " 失败...");
        System.out.println(result.getMethod().getMethodName() + " 失败!");*/
       /* super.onTestFailure(result);
        TestBase testBase = (TestBase) result.getInstance();
        //获取驱动
        WebDriver driver = testBase.getDriver();*/
        // 在报告中附加屏幕截图
       // saveFailureScreenShot(driver);
    }
   /* @Attachment(value = "失败截图如下：",type = "image/png")
    public void saveFailureScreenShot(WebDriver driver) {
        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("失败截图", new ByteArrayInputStream(screenshotAs));
    }*/
}
