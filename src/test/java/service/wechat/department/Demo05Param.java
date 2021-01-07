package service.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.wechat.apiObject.DepartMentObject;
import service.wechat.apiObject.TokenHelper;
import service.wechat.util.FakerUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mumu
 * @Description:
 * 1、基础用例,执行了创建，修改，查询
 * 2、优化：使用时间戳命名法避免入参重复造成的报错。
 * 3、优化：每个方法独立运行
 * 4、优化：对脚本进行了分层，减少了重复代码，提高了代码复用率，并减少了维护成本。
 * 5、优化：因为要覆盖不同的入参组合，以数据驱动的方式将入参从代码剥离。
 * @date 2021/1/7 20:07
 */
public class Demo05Param {
    private static final Logger logger = LoggerFactory.getLogger(Demo05Param.class);
    static String accessToken;

    @DisplayName("获取accessToken")
    @BeforeAll
    public static void getAccessToken(){
        accessToken = TokenHelper.getAccessToken();
        logger.info(accessToken);
    }

    @DisplayName("批量删除部门")
    @BeforeEach
    void clearDepartment(){
        DepartMentObject.clearDpartMentList(accessToken);
    }

    @DisplayName("创建部门")
    @Test
    void createDepartment(){
        String createName = "name" + FakerUtils.getTimeStamp();
        String createEnName = "en_name" + FakerUtils.getTimeStamp();
        Response createResponse = DepartMentObject.creatDepartMent(createName,createEnName,accessToken);
        assertEquals("0",createResponse.path("errcode").toString());
    }

    @DisplayName("修改部门")
    @Test
    void updateDepartment(){
        String updateName = "name" + FakerUtils.getTimeStamp();
        String updateEnName = "en_name" + FakerUtils.getTimeStamp();
        String departmentId = DepartMentObject.creatDepartMent(accessToken);
        Response updateResponse = DepartMentObject.updateDepartMent(updateName,updateEnName,departmentId,accessToken);

        assertEquals("0",updateResponse.path("errcode").toString());
    }
    @DisplayName("查询部门")
    @Test
    void listDepartment() {
        String departmentId = DepartMentObject.creatDepartMent(accessToken);
        Response response =DepartMentObject.listDepartMent(departmentId,accessToken);
        assertEquals("0",response.path("errcode").toString());
        assertEquals(departmentId,response.path("department.id[0]").toString());

    }
    @DisplayName("删除部门")
    @Test
    void deleteDepartment() {
        String departmentId = DepartMentObject.creatDepartMent(accessToken);

        Response response = DepartMentObject.deletDepartMent(departmentId,accessToken);
        assertEquals("0",response.path("errcode").toString());

    }
}
