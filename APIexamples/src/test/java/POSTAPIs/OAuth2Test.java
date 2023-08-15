package POSTAPIs;

import static io.restassured.RestAssured.given;

// if we give static imports we don't need to write restassured all the time in at the given() method  and rest assured is a class 
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth2Test {
	
static String accessToken;
	
	
	@BeforeMethod
	public void getAccessToken() {
		//1. POST - get the access token
				RestAssured.baseURI = "https://test.api.amadeus.com";
				
				 accessToken = given()
					.header("Content-Type", "application/x-www-form-urlencoded")
					.formParam("grant_type", "client_credentials")
					.formParam("client_id", "TAnRnsU5lASXZ8mPGdwRQZMoQzhu6Gwv")
					.formParam("client_secret", "VjjgfcJilNAzcSJw")
				.when()
					.post("/v1/security/oauth2/token")
				.then()
					.assertThat()
						.statusCode(200)
						.extract().path("access_token");
					
				System.out.println(accessToken);
				System.out.println("vin===========");
				
	}
	
	
	@Test
	public void getFlightInfoTest() {

		//2. get flight info: GET
	Response flightDataResponse = 	given().log().all()
		.header("Authorization", "Bearer "+accessToken)
		.queryParam("origin", "PAR")
		.queryParam("maxPrice", 200)
			.when().log().all()
				.get("/v1/shopping/flight-destinations")
			.then().log().all()
				.assertThat()
					.statusCode(200)
						.and()
							.extract()
								.response();;
	
	JsonPath js = flightDataResponse.jsonPath();
	String type = js.get("data[0].type");
	//int total = js.get("data[0].price.total");
	
	// directly pass and get all the info by jql - jason path syntax query 
	
   // List<Integer> priceList = js.getList("price.total");
    
   // for(int i=0; i<priceList.size(); i++) {
   //	 int total = priceList.get(i);
	
	
	System.out.println(type + " vindhya");//flight-destination
	//System.out.println(total + " vindhya");
	
   	 
   	// System.out.println( "total:" + " " + total); 
   	 
   	
 //   }
    
	
	
	
		
	}
	
	

}
