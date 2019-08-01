package deletetriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

class DeleteTriangleFromEmptyListTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности удалить треугольник из пустой базы")
    void deleteTriangleFromEmptyListTest() {
        String invalidId = "00000000-0000-0000-0000-000000000000";

        api.getAllTriangles()
                .then()
                .assertThat()
                .body("size()", is(0));

        Response response = api.deleteTriangle(invalidId);
        response.then()
                .assertThat()
                .statusCode(404)
                .body("error", equalTo("Not Found"))
                .body("message", equalTo("Not Found"));
    }
}
