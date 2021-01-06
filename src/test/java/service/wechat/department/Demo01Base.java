package service.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @program: junit4TestDemo
 * @description: 基础用例,执行了创建，修改，查询
 * @author: mumu
 * @create: 2020-12-29 23:30
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo01Base {
    static String accessToken;
    private String departmentId;

    /**
     * 获取access_token
     */
    @BeforeAll
    public static void getAccessToken(){
        accessToken =given().log().all()
                .when()
                .param("corpid","ww6771c7e77df1c587")
                .param("corpsecret", "6p2grqi4PSylesrvgqgCDaf1zJ0yXMiLsFRntdbL3H8")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .extract().response().path("access_token");
    }
    @DisplayName("创建部门")
    @Test
    @Order(1)
    void createDepartment(){
        String body =
                "{\n" +
                "   \"name\": \"广州研发中心\",\n" +
                "   \"name_en\": \"RDGZ\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "   \"id\": 2\n" +
                "}\n";
        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+accessToken)
                .then().log().all()
                .extract()
                .response();
     departmentId = response.path("id").toString();
    }

    @DisplayName("修改部门")
    @Test
    @Order(2)
    void updateDepartment(){
        String body =
                "{\n" +
                        "   \"name\": \"广州研发中心\",\n" +
                        "   \"name_en\": \"RDGZ\",\n" +
                        "   \"parentid\": 1,\n" +
                        "   \"order\": 1,\n" +
                        "   \"id\": "+departmentId+",\n" +
                        "}\n";
        Response response = given().log().all()
                .contentType("application/json")
                .body(body)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token" + accessToken)
                .then().log().body()
                .extract()
                .response();

       assertEquals("0",response.path("errcode").toString());

    }
    @DisplayName("查询部门")
    @Test
    @Order(3)
    void listDepartment() {

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
    @Order(4)
    void deleteDepartment() {
        Response response = given().log().all()
                .contentType("application/json")
                .param("access_token",accessToken)
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract().response()
                ;
        assertEquals("0",response.path("errcode").toString());

    }
}
