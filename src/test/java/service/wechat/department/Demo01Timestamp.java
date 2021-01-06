package service.wechat.department;

import io.restassured.response.Response;
import junit.framework.TestCase;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.wechat.util.FakerUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

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
        String name = "name" + FakerUtils.getTimeStamp();
        String enName = "en_name" + FakerUtils.getTimeStamp();
        String body ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
                "   \"parentid\": 1}";
        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then().log().body()
                .extract().response();
        departmentId = response.path("id")!=null ? response.path("id").toString():null;
        assertEquals("0",response.path("errcode").toString());
    }
    @DisplayName("查询部门")
    @Test
    @Order(3)
    void listDepartment() {
        String name = "name"+ FakerUtils.getTimeStamp();
        String enName = "en_name"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
                "   \"parentid\": 1}";
        Response creatResponse = given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then().log().body()
                .extract().response();
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        Response response =given().log().all()
                .when()
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",response.path("errcode").toString());
        assertEquals(departmentId,response.path("department.id[0]").toString());

    }
}
