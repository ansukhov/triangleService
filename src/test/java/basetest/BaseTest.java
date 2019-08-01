package basetest;

import helpers.api.TriangleApi;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected TriangleApi api = new TriangleApi();

    @BeforeEach
    public void setUp() {
        api.deleteAllTriangles();
    }
}
