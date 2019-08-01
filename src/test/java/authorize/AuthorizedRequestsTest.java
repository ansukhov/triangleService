package authorize;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

class AuthorizedRequestsTest extends BaseTest {

    @Test
    @DisplayName("Проверка запросов с токеном авторизации")
    void authorizedRequestsTest() {
        TriangleRequest model = new TriangleRequest("4;2;3");

        // POST  /triangle
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(200);
        String id = response.jsonPath().getString("id");

        // GET	/triangle/{triangleId}
        api.getTriangle(id)
                .then()
                .assertThat()
                .statusCode(200);

        // GET	/triangle/all
        api.getAllTriangles()
                .then()
                .assertThat()
                .statusCode(200);

        // GET	/triangle/{triangleId}/perimeter
        api.getPerimeter(id)
                .then()
                .assertThat()
                .statusCode(200);

        // GET	/triangle/{triangleId}/area
        api.getArea(id)
                .then()
                .assertThat()
                .statusCode(200);

        // DELETE	/triangle/{triangleId}
        api.deleteTriangle(id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
