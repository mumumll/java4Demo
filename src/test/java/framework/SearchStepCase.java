package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author mumu
 * @Description: 测试步骤驱动处理类
 * @date 2020/11/26 20:20
 */
public class SearchStepCase {
    public List<String> data;
    public List<HashMap<String, Object>> steps;
    private WebDriver driver;
    private WebElement currentElement;

    public void run() {
        steps.forEach(step->{
            if(step.keySet().contains("chrome")){
                driver = new ChromeDriver();
            }
            if(step.keySet().contains("firefox")){
                driver = new FirefoxDriver();
            }
            if(step.keySet().contains("edge")){
                driver = new EdgeDriver();
            }
            if (step.keySet().contains("implicitly_wait")){
                driver.manage().timeouts().implicitlyWait(
                        (int) step.getOrDefault("implicitly_wait",5), TimeUnit.SECONDS
                );
            }
            if(step.keySet().contains("get")){
                driver.get(step.get("get").toString());
            }
            if(step.keySet().contains("find")){
                ArrayList<By> bys = new ArrayList<By>();
                ((HashMap<String, String>)step.get("find")).entrySet().forEach(stringStringEntry -> {
                    if(stringStringEntry.getKey().contains("id")){
                        bys.add(By.id(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("xpath")){
                        bys.add(By.xpath(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("name")){
                        bys.add(By.name(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("cssSelector")){
                        bys.add(By.cssSelector(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("className")){
                        bys.add(By.className(stringStringEntry.getValue()));
                    }
                    if(stringStringEntry.getKey().contains("linkText")){
                        bys.add(By.linkText(stringStringEntry.getValue()));
                    }

                });
                currentElement = driver.findElement(bys.get(0));
            }
            if(step.keySet().contains("click")){
                currentElement.click();
            }
            if(step.keySet().contains("send_keys")){
                currentElement.sendKeys("xixihaha");
            }
        });
    }
}
