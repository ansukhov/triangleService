package areacalculation;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.IsEqual.equalTo;

class GetAreaNotExistingTriangleTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности расчета площади треугольника с некорректным ID")
    void getAreaNotExistingTriangleTest() {
        String invalidId = "00000000-0000-0000-0000-000000000000";
        TriangleRequest model = new TriangleRequest("4;4;4");
        api.addTriangle(model);

        Response response = api.getPerimeter(invalidId);
        response.then()
                .assertThat()
                .statusCode(404)
                .body("error", equalTo("Not Found"))
                .body("message", equalTo("Not Found"));
    }
}
