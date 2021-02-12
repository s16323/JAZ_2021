package pl.edu.pjwstk.jaz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;                   //na ćwiczeniach

@RunWith(SpringRunner.class)
@IntegrationTest
public class ExampleTest {
    @Test
    public void should_respond_to_readiness_request() {
        var response = given()
                .when()
                .get("/api/is-ready")
                .thenReturn();                           // kiedy zapytamy GET, na path: "/api/is-ready"
        var statusCode = response.getStatusCode();  // powinniśmy dostać status code

        assertThat(statusCode).isEqualTo(200);           //HTTP status code: 200-OK
    }
}
