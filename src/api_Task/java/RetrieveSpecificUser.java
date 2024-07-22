import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RetrieveSpecificUser {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetUserById() {
        int userId = 20;

        given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("name", not(empty())) // Assuming 'name' should not be empty
                .body("email", containsString("@")); // Assuming 'email' should contain '@'
    }
}
