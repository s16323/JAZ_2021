package pl.edu.pjwstk.jaz.average;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pjwstk.jaz.IntegrationTest;

import static io.restassured.RestAssured.given;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;                   //na ćwiczeniach
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@IntegrationTest
public class AverageControllerIT {

    @Test
    public void should_calculate_simple_average() {
        given()
                .param("numbers", "1,2,3")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 2"));
    }

    @Test
    public void should_calculate_multi_digit_numbers() {
        given()
                .param("numbers", "11,20,33")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 21.33"));
    }

    @Test
    public void should_remove_trailing_zeros(){
        given()
                .param("numbers", "1,2,3,4")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 2.5"));
    }


    @Test
    public void should_have_max_two_decimal_digits(){
        given()
                .param("numbers", "1,1,2")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 1.33"));
    }

    @Test
    public void should_prompt_when_no_parameter_given(){
        given()
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Please put parameters."));
    }

    @Test
    public void should_prompt_when_empty_string_in_parameter_given(){
        given()
                .param("numbers", "")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Please put parameters."));
    }

    @Test
    public void should_prompt_when_non_numbers_in_parameter_given(){
        given()
                .param("numbers", "Aa!@#$%^&*()_+-={}[]|;':,.<>?/`~")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Please put parameters."));
    }
}