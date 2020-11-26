package framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author mumu
 * @Description: 参数化测试
 * @date 2020/11/26 16:56
 */
public class ParamsTest {

    /**
     * 方法参数化
     * @param argument
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    /**
     * 测试数据驱动
     * @param keyword
     */
    @ParameterizedTest
    @MethodSource()
    void search(String keyword){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
        // 查找搜索按钮并点击
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys(keyword);

    }
    static List<String> search() throws IOException {
//        return Stream.of("nihao","world");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<String>> typeReference = new TypeReference<List<String>>() {
        };
        List<String> keywords = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search.yaml"),
                typeReference);
        return keywords;
    }

    /**
     * 测试步骤驱动
     * @param searchStepCase
     */
    @ParameterizedTest
    @MethodSource()
    void searchStep(SearchStepCase searchStepCase){
        System.out.println(searchStepCase);
        //done: runner引擎
        searchStepCase.run();

    }
    static Stream<SearchStepCase> searchStep() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        SearchStepCase searchStepCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search_step.yaml"),
                SearchStepCase.class);
        return Stream.of(searchStepCase);
    }
}
