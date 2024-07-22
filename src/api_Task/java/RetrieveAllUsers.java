
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class RetrieveAllUsers {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetAllPosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(100)); // Assuming there are 100 posts, adjust as per actual data
    }

    @Test
    public void testGetPostById() {
        int postId = 1; // Example post ID
        given()
                .pathParam("id", postId)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(postId));
    }

    @Test
    public void testCreatePost() {
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}
