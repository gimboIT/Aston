package specs;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoSpecs {

    static final String url = "https://postman-echo.com";
    public RequestSpecification baseRequestSpec(String url) {
        return given()
                .baseUri(url)
                .contentType("application/json")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2");
    }
    public RequestSpecification getRequestSpec = baseRequestSpec(url)
            .basePath("/get");
    public RequestSpecification postRequestSpec = baseRequestSpec(url)
            .basePath("/post");
    public RequestSpecification putRequestSpec = baseRequestSpec(url)
            .basePath("/put");
    public RequestSpecification patchRequestSpec = baseRequestSpec(url)
            .basePath("/patch");
    public RequestSpecification deleteRequestSpec = baseRequestSpec(url)
            .basePath("/delete");

    public ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .body("args.foo1", equalTo("bar1"))
            .body("args.foo2", equalTo("bar2"));
}