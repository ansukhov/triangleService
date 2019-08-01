package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CheckInvalidTrianglesTest extends BaseTest {

    @ParameterizedTest(name = "Добавление невалидного треугольника с input = {0}")
    @DisplayName("Добавление невалидных треугольников")
    @ValueSource(strings = {"0;1;1", "10;1;1", "1;-1;1", "2;1;1"})
    void checkValidInputTest(String input) {
        TriangleRequest model = new TriangleRequest(input);
        Response response = api.addTriangle(model);
        System.out.println(response.asString());
        response.then()
                .assertThat()
                .statusCode(422);
    }
}
