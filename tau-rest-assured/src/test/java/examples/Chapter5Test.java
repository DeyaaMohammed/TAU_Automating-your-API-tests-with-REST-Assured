package examples;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter5Test {
    //Using WireMock to mock XML Responses
    //Adding Rule to automatically start and stop WireMock per-test case
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

    //Checking Contents of an XML Response Body
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
        when().
                get("http://localhost:9876/us/90210").
        then().
                assertThat().
                body("response.places.place.placeName", equalTo("Beverly Hills"));
    }

    //Retrieving an element at a specific position in the XML response
    @Test
    public void requestDeZipCode24848_checkThirdPlaceNameInResponseBody_expectKropp() {

        given().
        when().
                get("http://localhost:9876/de/24848").
        then().
                assertThat().
                body("response.places.place[2].placeName", equalTo("Kropp"));
    }

    //Retrieving  the last occurrence of an element in the XML response
    @Test
    public void requestDeZipCode24848_checkLastPlaceNameInResponseBody_expectKleinBennebek() {

        given().
        when().
                get("http://localhost:9876/de/24848").
        then().
                assertThat().
                body("response.places.place[-1].placeName", equalTo("Klein Bennebek"));
    }

    //Check the value of an attribute within an element in the XML response using '@'
    @Test
    public void requestDeZipCode24848_checkLatitudeForSecondPlaceInResponseBody_expect5445() {

        given().
        when().
                get("http://localhost:9876/de/24848").
        then().
                assertThat().
                body("response.places.place[1].@latitude", equalTo("54.45"));
    }

    //Using "findAll" filter to check that all of the places that are associated with the ZIP code 24848 in Germany
    // are part of the state with the name "Schleswig-Holstein"
    @Test
    public void requestDeZipCode24848_checkNumberOfPlacesWithStateAbbreviationSH_expect4() {

        given().
        when().
                get("http://localhost:9876/de/24848").
        then().
                assertThat().
                body("response.places.place.findAll{it.stateAbbreviation!='SH'}", empty());
    }
}
