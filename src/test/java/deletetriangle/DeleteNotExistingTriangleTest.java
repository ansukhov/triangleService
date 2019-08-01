package deletetriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

class DeleteNotExistingTriangleTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности удалить треугольник по некорректному ID")
    void deleteNotExistingTriangleTest() {
        String invalidId = "00000000-0000-0000-0000-000000000000";

        TriangleRequest model = new TriangleRequest("4;4;4");
        api.addTriangle(model);

        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(1));

        Response response = api.deleteTriangle(invalidId);
        response.then()
                .assertThat()
                .statusCode(404)
                .body("error", equalTo("Not Found"))
                .body("message", equalTo("Not Found"));

        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(1));
    }
}
