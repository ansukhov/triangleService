package helpers.api;

import endpoints.TriangleEndpoints;
import helpers.PropertiesUtils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.TriangleRequest;
import org.slf4j.*;

public class UnauthTriangleApi {

    private static final Logger log = LoggerFactory.getLogger(TriangleApi.class.getSimpleName());

    private String serviceUri = PropertiesUtils.getProperty("service.host");

    private RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri(serviceUri)
            .setContentType(ContentType.JSON)
            .build();

    /**
     * Add triangle without token
     * @param triangleRequest - triangle model
     * @return response of POST /triangle
     */
    public Response addTriangle(TriangleRequest triangleRequest) {
        log.info(String.format("Add triangle - %s", triangleRequest));
        return RestAssured.given(reqSpec)
                .body(triangleRequest)
                .post(TriangleEndpoints.ADD_TRIANGLE);
    }

    /**
     * Get triangle by ID without token
     * @param triangleId - triangle ID
     * @return response of GET /triangle/{triangleId}
     */
    public Response getTriangle(String triangleId) {
        log.info(String.format("Get triangle with ID - %s", triangleId));
        return RestAssured.given(reqSpec)
                .get(TriangleEndpoints.GET_TRIANGLE, triangleId);
    }

    /**
     * Delete triangle by ID without token
     * @param triangleId - triangle ID
     * @return response of DELETE /triangle/{triangleId}
     */
    public Response deleteTriangle(String triangleId) {
        log.info(String.format("Delete triangle with ID - %s", triangleId));
        return RestAssured.given(reqSpec)
                .delete(TriangleEndpoints.DELETE_TRIANGLE, triangleId);
    }

    /**
     * Get all triangles without token
     * @return response of GET /triangle/all
     */
    public Response getAllTriangles() {
        log.info("Get all triangles");
        return RestAssured.given(reqSpec)
                .get(TriangleEndpoints.GET_ALL_TRIANGLE);
    }

    /**
     * Get perimeter of triangle with ID without token
     * @param triangleId - triangle ID
     * @return response of GET /triangle/{triangleId}/perimeter
     */
    public Response getPerimeter(String triangleId) {
        log.info(String.format("Get perimeter of triangle with ID - %s", triangleId));
        return RestAssured.given(reqSpec)
                .get(TriangleEndpoints.GET_PERIMETER, triangleId);
    }

    /**
     * Get area of triangle with ID without token
     * @param triangleId - triangle ID
     * @return response of GET /triangle/{triangleId}/area
     */
    public Response getArea(String triangleId) {
        log.info(String.format("Get area of triangle with ID - %s", triangleId));
        return RestAssured.given(reqSpec)
                .get(TriangleEndpoints.GET_AREA, triangleId);
    }
}
