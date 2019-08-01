package getalltriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

class GetAllTrianglesTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности получить информацию о всех треугольниках")
    void getAllTrianglesTest() {
        TriangleRequest model = new TriangleRequest("4;4;4");
        Response response = api.addTriangle(model);
        String firstId = response.jsonPath().getString("id");

        api.getAllTriangles()
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(1))
                .body("id", containsInAnyOrder(firstId));

        response = api.addTriangle(model);
        String secondId = response.jsonPath().getString("id");

        api.getAllTriangles()
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(2))
                .body("id", containsInAnyOrder(firstId, secondId));
    }
}
