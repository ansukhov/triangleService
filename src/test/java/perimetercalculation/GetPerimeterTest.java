package perimetercalculation;

import basetest.BaseTest;
import helpers.MathCalculation;
import io.restassured.response.Response;
import models.TriangleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.core.IsEqual.equalTo;

class GetPerimeterTest extends BaseTest {

    @ParameterizedTest(name = "Расчет периметра треугольника с input = {0}")
    @DisplayName("Расчет периметра треугольника")
    @ValueSource(strings = {"1;1;1", "5;4;3", "10000;10000;10000", "0;1;1"})
    void getPerimeterTest(String input) {
        float perimeter = MathCalculation.calculatePerimeter(input, ";");
        TriangleRequest model = new TriangleRequest(input);
        Response response = api.addTriangle(model);
        String id = response.jsonPath().getString("id");

        response = api.getPerimeter(id);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("result", equalTo(perimeter));
    }
}
