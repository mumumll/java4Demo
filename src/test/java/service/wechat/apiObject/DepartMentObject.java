package service.wechat.apiObject;

import io.restassured.response.Response;
import service.wechat.util.FakerUtils;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * @author mumu
 * @Description: 部门对象操作
 * @date 2021/1/7 19:48
 */
public class DepartMentObject {

    /**
     * 创建部门，返回部门信息
     * @param creatName
     * @param creatEnName
     * @param accessToken
     * @return
     */
    public static Response creatDepartMent(String creatName,String creatEnName,String accessToken) {
        String creatBody = "{\n" +
                "   \"name\": \"" + creatName + "\",\n" +
                "   \"name_en\": \"" + creatEnName + "\",\n" +
                "   \"parentid\": 1}";
        Response creatResponse = given().log().all()
                .contentType("application/json")
                .body(creatBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken)
                .then().log().body()
                .extract().response();
        return creatResponse;
    }

    /**
     * 创建部门，返回部门ID
     * @param accessToken
     * @return
     */
    public static String creatDepartMent(String accessToken){
        String creatName= "name"+ FakerUtils.getTimeStamp();
        String creatEnName="en_name"+ FakerUtils.getTimeStamp();
        Response creatResponse = creatDepartMent(creatName,creatEnName,accessToken);
        String departmentId= creatResponse.path("id")!=null ? creatResponse.path("id").toString():null;
        return departmentId;
    }

    /**
     * 更新部门，返回部门信息
     * @param updateName
     * @param updateEnName
     * @param departmentId
     * @param accessToken
     * @return
     *
     */
    public static Response updateDepartMent(String updateName,String updateEnName,String departmentId,String accessToken){
        String updateBody ="{\n" +
                "   \"id\": "+departmentId+",\n" +
                "   \"name\": \""+updateName+"\",\n" +
                "   \"name_en\": \""+updateEnName+"\",\n" +
                "   \"order\": 1\n" +
                "}\n";
        Response updateResponse=given().log().all()
                .contentType("application/json")
                .body(updateBody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+accessToken+"")
                .then().log().body()
                .extract().response();
        return updateResponse;
    }

    /**
     * 查询所有部门，返回部门列表信息
     * @param departmentId
     * @param accessToken
     * @return
     */
    public static Response listDepartMent(String departmentId,String accessToken){
        Response listResponse =given().log().all()
                .when()
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+accessToken)
                .then()
                .log().body()
                .extract().response();
        return listResponse;
    }

    /**
     * 删除部门
     * @param departmentId
     * @param accessToken
     * @return
     */
    public static Response deletDepartMent(String departmentId,String accessToken){
        Response deletResponse = given().log().all()
                .contentType("application/json")
                .param("access_token",accessToken)
                .param("id",departmentId)
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().body()
                .extract().response();
        return deletResponse;
    }

    /**
     * 批量删除部门
     * @param accessToken
     */
    public static void clearDpartMentList(String accessToken){
        ArrayList<Integer> departmentIds = listDepartMent("",accessToken).path("department.id");
        for( int departmentId:departmentIds){
            if(1==departmentId)
                continue;
            DepartMentObject.deletDepartMent(departmentId+"",accessToken);
        }
    }
}
