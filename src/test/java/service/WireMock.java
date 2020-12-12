package service;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author mumu
 * @Description: wiremock练习
 * @date 2020/12/12 15:49
 */
public class WireMock {
    static WireMockRule wireMockRule;
    @BeforeAll
    static void init(){
        wireMockRule = new WireMockRule(wireMockConfig().port(8089));
        wireMockRule.start();
        configureFor("localhost", 8089);
    }
    @Test
    void stubTest() throws InterruptedException {
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));
        Thread.sleep(1000000);
    }
    @Test
    public void easyMockTest() {
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>mumu</response>")));
        try {
            Thread.sleep(10000);
            reset();
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept", equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "text/xml")
                            .withBody("<response>大家好，我来了</response>")));
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void proxyMockTest(){
        try {
            stubFor(get(urlMatching(".*")).atPriority(10)
                    .willReturn(aResponse().proxiedFrom("https://ceshiren.com")));

            stubFor(get(urlEqualTo("/categories_and_latest")).atPriority(10)
                    .willReturn(aResponse().withBody(Files.readAllBytes(Paths.get(WireMock.class.getResource("/mock.json").toURI())))));

            Thread.sleep(500000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
