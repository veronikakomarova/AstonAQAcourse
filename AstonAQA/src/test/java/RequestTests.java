import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestTests {

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://postman-echo.com")
            .addHeader("my-header1", "value1")
            .addHeader("my-header2", "value2")
            .build();

    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    @Test
    public void getShouldReturnAllQueryParamsInArgs() {
        Map<String, String> queryParams = Map.of(
                "foo1", "test1",
                "foo2", "test2"
        );


        EchoResponse responseBody = given()
                .spec(requestSpec)
                .queryParams(queryParams)
                .when()
                .get("/get")
                .then()
                .spec(responseSpec)
                .extract()
                .as(EchoResponse.class);

        Assert.assertNotNull(responseBody);

        Map<String, String> args = responseBody.getArgs();
        Assert.assertNotNull(args);
        Assert.assertEquals(args, queryParams);
        assertHeaders(responseBody);
    }

    @Test
    public void postShouldReturnAllFormFieldsInForm() {
        Map<String, String> formFields = Map.of(
                "name", "Veronika",
                "role", "qa",
                "test", "api"
        );


        EchoResponse responseBody = given()
                .spec(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formFields)
                .when()
                .post("/post")
                .then()
                .spec(responseSpec)
                .extract()
                .as(EchoResponse.class);

        Map<String, String> form = responseBody.getForm();
        Assert.assertNotNull(responseBody);
        Assert.assertNotNull(form);
        Assert.assertEquals(form, formFields);
        assertHeaders(responseBody);
    }

    @DataProvider(name = "rawBodyEndpoints")
    public Object[][] getRawBodyEndpoints() {
        return new Object[][]{
                {"POST", "/post"},
                {"PUT", "/put"},
                {"PATCH", "/patch"},
                {"DELETE", "/delete"}
        };
    }


    @Test(dataProvider = "rawBodyEndpoints")
    public void rawBodyEndpointsShouldReturnRawBodyInData(String method, String endpoint) {
        String rawText = "This is expected to be sent back as part of response body.";

        EchoResponse responseBody = given()
                .spec(requestSpec)
                .contentType(ContentType.TEXT)
                .body(rawText)
                .when()
                .request(method, endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .as(EchoResponse.class);


        Assert.assertNotNull(responseBody);
        String data = responseBody.getData();
        Assert.assertEquals(data, rawText);
        assertHeaders(responseBody);
    }

    private void assertHeaders(EchoResponse responseBody) {
        Assert.assertNotNull(responseBody.getHeaders());
        Map<String, String> headers = responseBody.getHeaders();

        String header1 = headers.get("my-header1");
        String header2 = headers.get("my-header2");
        Assert.assertEquals(header1, "value1");
        Assert.assertEquals(header2, "value2");
    }
}



