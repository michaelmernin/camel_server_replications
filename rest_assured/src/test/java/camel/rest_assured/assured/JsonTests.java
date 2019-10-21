package camel.rest_assured.assured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//import static io.restassured.path.*;

public class JsonTests {
    @Test
    public void python(){
        post("http://127.0.0.1:5000/sync?last_entry=0").then().statusCode(200).assertThat()
                .body("status", equalTo("unchanged"));
    }
}
