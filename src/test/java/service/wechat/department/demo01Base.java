package service.wechat.department;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @program: junit4TestDemo
 * @description: 基础用例
 * @author: mumu
 * @create: 2020-12-29 23:30
 **/
public class demo01Base {
    static String access_token;

    /**
     * 获取access_token
     */
    @BeforeAll
    public static void getAccessToken(){
        access_token =given().log().all()
                .when()
                .param("corpid","ww6771c7e77df1c587")
                .param("corpsecret", "6p2grqi4PSylesrvgqgCDWZcr5dM62oDOSdCQB7gkUQ")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .extract().response().path("access_token");
    }
    @Test
    void createDepartment(){

    }

}
