package addtriangle;

import basetest.BaseTest;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

class CheckValidInputTest extends BaseTest {

    @ParameterizedTest(name = "Добавление треугольника с input = {0}")
    @DisplayName("Добавление треугольника с разлиными input")
    @ValueSource(strings = {"1;1;1", "2;2;4", "10000;10000;10000"})
    void checkValidInputTest(String input) {
        String[] inputArr = input.split(";");
        TriangleRequest model = new TriangleRequest(input);
        Response response = api.addTriangle(model);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", notNullValue())
                .body("firstSide", equalTo(Float.parseFloat(inputArr[0])))
                .body("secondSide", equalTo(Float.parseFloat(inputArr[1])))
                .body("thirdSide", equalTo(Float.parseFloat(inputArr[2])));
    }
}
