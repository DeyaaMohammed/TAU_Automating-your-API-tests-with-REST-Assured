package examples;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter2Test {
    //Checking the response status code
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                statusCode(200);
                //statusCode(201);      //Should fail
    }

    //Checking the response content type
    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                contentType(ContentType.JSON);
                //contentType("application/json");
                //contentType(ContentType.XML);     //Should fail
    }

    //Logging request and response details
    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {

        given().
                log().all().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                log().body();
    }

    //Checking the response body
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkStateNameInResponseBody_expectCalifornia() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                body("places[0].state", equalTo("California"));
    }

    @Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
                //body("places.'place name'", not(hasItem("Beverly Hills"))); //Should fail
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne() {

        given().
        when().
                get("http://zippopotam.us/us/90210").
        then().
                assertThat().
                body("places.'place name'", hasSize(1));
                //body("places.'place name'", hasSize(2));  //Should fail
    }
}
