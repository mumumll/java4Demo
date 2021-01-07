package service.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.wechat.util.FakerUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

/**
 * @author mumu
 * @Description:
 * 1、基础用例,执行了创建，修改，查询
 * 2、优化：使用时间戳命名法避免入参重复造成的报错。
 * 3、优化：每个方法独立运行
 *
 * @date 2021/1/6 11:58
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo02Timestamp {
    private static final Logger logger = LoggerFactory.getLogger(Demo02Timestamp.class);
    static String accessToken;
    static String departmentId;

    @DisplayName("获取accessToken")
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
    @DisplayName("修改部门")
    @Test
    void updateDepartment(){
        String name = "name"+ FakerUtils.getTimeStamp();
        String enName = "en_name"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName +"\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract().response();
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        String updateBody ="{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
                "   \"order\": 1\n" +
                "}\n";
        Response updateResponse=given().log().all()
                .contentType("application/json")
                .body(updateBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+accessToken)
                .then()
                .log().body()
                .extract().response();
        assertEquals("0",updateResponse.path("errcode").toString());
    }

    @DisplayName("查询部门")
    @Test
    void listDepartment() {
        String name = "name"+ FakerUtils.getTimeStamp();
        String enName = "en_name"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response();
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
    @DisplayName("删除部门")
    @Test
    void deleteDepartment() {
        String name = "name"+ FakerUtils.getTimeStamp();
        String enName = "en_name"+FakerUtils.getTimeStamp();
        String creatBody ="{\n" +
                "   \"name\": \""+name+"\",\n" +
                "   \"name_en\": \""+enName+"\",\n" +
                "   \"parentid\": 1}";
        final Response creatResponse=given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken+"")
                .then()
                .log().body()
                .extract()
                .response();
        String departmentId=creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        Response response = given().log().all()
                .contentType("application/json")
                .param("access_token",accessToken)
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all()
                .extract().response();
        assertEquals("0",response.path("errcode").toString());
    }
}
