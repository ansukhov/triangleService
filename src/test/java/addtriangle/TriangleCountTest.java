package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.Is.is;


class TriangleCountTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности добавить не более 10 треугольников")
    void triangleCountTest() {
        Response response;
        TriangleRequest model = new TriangleRequest("4;4;4");
        for (int i = 0; i < 10; i++) {
            response = api.addTriangle(model);
            response.then()
                    .assertThat()
                    .statusCode(200);
        }
        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(10));

        // добавляем 11 треугольник
        api.addTriangle(model);
        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(10));

    }
}
