package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack extends ConfigSettings {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(browserstackConfig.getUser(), browserstackConfig.getKey())
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
