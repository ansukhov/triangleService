package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class CheckDefaultSeparatorTest extends BaseTest {

    @Test
    @DisplayName("Проверка возможности добавления треугольник без указания separator")
    void checkDefaultSeparatorTest() {
        TriangleRequest model = new TriangleRequest("4;4;4");
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", notNullValue())
                .body("firstSide", equalTo((float) 4))
                .body("secondSide", equalTo((float) 4))
                .body("thirdSide", equalTo((float) 4));
    }
}
