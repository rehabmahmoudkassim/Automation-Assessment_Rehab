import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class CreatUserAccount {
    @Test
    public void testCreatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Define the request body for creating a post
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // Perform POST request
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .assertThat().statusCode(201) // Assert HTTP status code 201 (Created)
                .body("title", equalTo("foo")) // Assert response body
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}


