package helpers;

import tests.TestBase;

import static io.restassured.RestAssured.given;

public class Browserstack extends TestBase {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(secretsConfig.browserstack_user(), secretsConfig.browserstack_key())
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
