package examples;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class Chapter3Test {
    //Step 1: Create a test data collection
    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
                //Step 4: Update the specified test data
                ,{"nl", "1001", "Amsterdam"}
        };
    }

    //Step 2: Feed data collection to your test method
    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName) {

        given().
                //Step 3: Use path parameters to parametrize REST Assured tests
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
        then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
