package authorize;

import basetest.BaseTest;
import helpers.api.UnauthTriangleApi;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

class UnauthorizedRequestsTest extends BaseTest {

    private UnauthTriangleApi api = new UnauthTriangleApi();

    @Test
    @DisplayName("Проверка запросов без токена авторизации")
    void unauthorizedRequestsTest() {
        TriangleRequest model = new TriangleRequest("4;2;3");

        // POST  /triangle
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(401);

        // GET	/triangle/{triangleId}
        api.getTriangle("")
                .then()
                .assertThat()
                .statusCode(401);

        // GET	/triangle/all
        api.getAllTriangles()
                .then()
                .assertThat()
                .statusCode(401);

        // GET	/triangle/{triangleId}/perimeter
        api.getPerimeter("")
                .then()
                .assertThat()
                .statusCode(401);

        // GET	/triangle/{triangleId}/area
        api.getArea("")
                .then()
                .assertThat()
                .statusCode(401);

        // DELETE	/triangle/{triangleId}
        api.deleteTriangle("")
                .then()
                .assertThat()
                .statusCode(401);
    }
}
