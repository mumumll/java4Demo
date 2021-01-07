package service.wechat.apiObject;

import static io.restassured.RestAssured.given;

/**
 * @author mumu
 * @Description: 公共类:获取access_token
 * @date 2021/1/7 20:04
 */
public class TokenHelper {

    /**
     * 获取access_token
     * @return
     */
    public static String getAccessToken(){
        String accessToken =given().log().all()
                .when()
                .param("corpid","ww6771c7e77df1c587")
                .param("corpsecret", "6p2grqi4PSylesrvgqgCDaf1zJ0yXMiLsFRntdbL3H8")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .extract().response().path("access_token");
        return accessToken;
    }
}
