package service;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @program: junit4TestDemo
 * @description: rest-assured学习
 * @author: mumu
 * @create: 2020-12-16 21:53
 **/
public class RestAssureTest {
    @Test
    void josnTest(){
        given().log().all();
    }
}
