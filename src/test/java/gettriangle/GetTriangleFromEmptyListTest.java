package gettriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.IsEqual.equalTo;

class GetTriangleFromEmptyListTest extends BaseTest {

    @Test
    @DisplayName("Проверка получение информацию, когда в базе пусто")
    void getTriangleFromEmptyListTest() {
        String id = "00000000-0000-0000-0000-000000000000";

        Response response = api.getTriangle(id);
        response.then()
                .assertThat()
                .statusCode(404)
                .body("error", equalTo("Not Found"))
                .body("message", equalTo("Not Found"));
    }
}
