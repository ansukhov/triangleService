package gettriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.IsEqual.equalTo;

class GetTriangleTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности получить информацию о треугольники по ID")
    void getTriangleTest() {
        TriangleRequest model = new TriangleRequest("4;4;4");
        Response response = api.addTriangle(model);
        String id = response.jsonPath().getString("id");

        response = api.getTriangle(id);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(id))
                .body("firstSide", equalTo((float) 4))
                .body("secondSide", equalTo((float) 4))
                .body("thirdSide", equalTo((float) 4));
    }
}
