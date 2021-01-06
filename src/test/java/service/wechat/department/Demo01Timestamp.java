package service.wechat.department;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

/**
 * @author mumu
 * @Description:使用时间戳命名法避免入参重复造成的报错。
 * @date 2021/1/6 11:58
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo01Timestamp {
    private static final Logger logger = LoggerFactory.getLogger(Demo01Timestamp.class);
    static String accessToken;
    static String departmentId;

    /**
     * 获取accessToken
     */
    @BeforeAll
    public static void getAccessToken(){
        accessToken =given()
                .when()
                .param("corpid","ww6771c7e77df1c587")
                .param("corpsecret", "6p2grqi4PSylesrvgqgCDaf1zJ0yXMiLsFRntdbL3H8")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .extract().response().path("access_token");
        logger.info(accessToken);
    }

    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment(){

    }
}
