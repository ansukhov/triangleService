package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.core.IsEqual.equalTo;

class CheckInvalidInputTest extends BaseTest {

    @ParameterizedTest(name = "Добавление треугольника с невалидным input = {0}")
    @DisplayName("Добавление треугольника с разлиными невалиждными input")
    @ValueSource(strings = {"1;1;", "1;1,1", "111", "1;1;d", ";;", ""})
    void checkValidInputTest(String input) {
        TriangleRequest model = new TriangleRequest(input);
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(422)
                .body("error", equalTo("Unprocessable Entity"))
                .body("message", equalTo("Cannot process input"));
    }
}
