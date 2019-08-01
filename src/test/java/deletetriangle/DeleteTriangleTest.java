package deletetriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.Is.is;

class DeleteTriangleTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности удалить треугольник по ID")
    void deleteTriangleTest() {
        TriangleRequest model = new TriangleRequest("4;4;4");
        Response response = api.addTriangle(model);
        String id = response.jsonPath().getString("id");

        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(1));

        response = api.deleteTriangle(id);
        response.then()
                .assertThat()
                .statusCode(200);

        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(0));
    }
}
