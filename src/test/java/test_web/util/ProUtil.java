package test_web.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mumu
 * @Description: 获取元素工具类
 * @date 2020/11/18 14:27
 */
public class ProUtil {
    public Properties Pro;
    public ProUtil(String FilePath) {
        Pro = RedProperties(FilePath);
    }
    private Properties RedProperties(String FilePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(FilePath);
            BufferedInputStream In = new BufferedInputStream(fileInputStream);
            properties.load(In);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties;

    }

    public String GetPro(String key) {
        String value;
        if (Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }else {
            return "";
        }
    }
    public int GetLines() {
        return Pro.size();
    }
  /*  public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String FilePath;
        ProUtil ProU = new ProUtil("H:\\IdeaSpace\\xunitTestDemo\\java4Demo\\src\\main\\resources\\element.properties");
        System.out.println(ProU.GetPro("username"));
    }*/

}
