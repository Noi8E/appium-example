package helpers;

import tests.TestBase;

import static io.restassured.RestAssured.given;

public class Browserstack extends TestBase {
    //test

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(secretsConfig.browserstackUser(), secretsConfig.browserstackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");

    }
}
