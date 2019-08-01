package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class CheckVariousSeparatorTest extends BaseTest {

    @ParameterizedTest(name = "Добавление треугольника с separator = {0}")
    @DisplayName("Добавление треугольника с разлиными separator")
    @ValueSource(strings = {":", ";", ".", "!", ">", "$", "%", "5", "d", "_", "+", ","})
    void addTriangleWithVariousSeparatorTest(String separator) {
        String input = String.format("4%s3%s2", separator, separator);
        TriangleRequest model = new TriangleRequest(separator, input);
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", notNullValue())
                .body("firstSide", equalTo((float) 4))
                .body("secondSide", equalTo((float) 3))
                .body("thirdSide", equalTo((float) 2));
    }
}
