package gray.c.one.controller;

import com.jayway.restassured.response.Response;
import gray.c.one.model.Information;
import gray.c.one.model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by jykang on 2016. 10. 26..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RemoteControllerTest {

    private Information information = new Information();

    @Before
    public void setup() {

        information.setLocation(new Location(10, 10));
        information.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


    @Test
    public void test() {

        Response response = given()
                .contentType("application/json;charset=UTF-8")
                .log().all()
                .queryParam("message", "몇시니")
                .request().body(information)
                .post("http://localhost:5160/test")
                .prettyPeek();

        String result = response.body().print();

        Assert.assertEquals("12시 30분", result);

    }
}
