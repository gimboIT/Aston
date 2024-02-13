package tests;

import org.junit.jupiter.api.Test;
import specs.PostmanEchoSpecs;

public class PostmanEchoTest extends PostmanEchoSpecs {

    @Test
    public void getRequestTest() {
        getRequestSpec
                .when()
                .get()
                .then()
                .spec(responseSpec);
    }

    @Test
    public void postFormDataTest() {
        postRequestSpec
                .when()
                .post()
                .then()
                .spec(responseSpec);
    }

    @Test
    public void putRequestTest() {
        putRequestSpec
                .when()
                .put()
                .then()
                .spec(responseSpec);

    }

    @Test
    public void patchRequestTest() {
        patchRequestSpec
                .when()
                .patch()
                .then()
                .spec(responseSpec);
    }

    @Test
    public void deleteRequestTest() {
        deleteRequestSpec
                .when()
                .delete()
                .then()
                .spec(responseSpec);
    }
}
