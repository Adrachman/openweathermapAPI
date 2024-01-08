import fileBulder.Builder;
import io.restassured.http.ContentType;
import models.Coord;
import models.Main;
import models.Wind;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class OpenweathermapTest {
    @Test
    public void descriptionWeather () {
        Wind wind = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather?lat=59.9&lon=30.3&appid=5950e0c86525da2ec44ad6665110a5fe")
                .then().log().body()
                .extract().jsonPath().getObject("wind", Wind.class);

        Main main = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather?lat=59.9&lon=30.3&appid=5950e0c86525da2ec44ad6665110a5fe")
                .then()
                .extract().jsonPath().getObject("main", Main.class);
        Builder.getFile();
        Builder.putFile(main.toString(), wind.toString());

    }
}
