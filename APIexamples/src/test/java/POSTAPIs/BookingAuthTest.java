package POSTAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.File;


public class BookingAuthTest {
	
	@Test
	public void getBookingAuthTokenTest_With_Json_String() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String tokenId = given()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \"username\" : \"admin\",\n"
					+ "    \"password\" : \"password123\"\n"
					+ "}")
			.when()
				.post("/auth")
					.then()
						.assertThat()
							.statusCode(200)
								.extract()
									.path("token");
					
		// this is just generating the token here thats why status code is 200
		
		System.out.println(tokenId);	
		Assert.assertNotNull(tokenId);
		
		
	}
	
	
	@Test
	public void getBookingAuthTokenTest_With_JSON_File() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String tokenId = given()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/TestData/basicauth.json"))
			.when()
				.post("/auth")
					.then()
						.assertThat()
							.statusCode(200)
								.extract()
									.path("token");
					
			
		System.out.println(tokenId);	
		Assert.assertNotNull(tokenId);
		
		
	}
	
	
	//post -- add a user -- user id = 123 -- assert(201, body)
	//get --> get a user --> /users/123 -- 200 -- userid=123
	
	@Test
	public void addUserTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		//1. add user - POST
		int userId = given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/TestData/adduser.json"))
			.header("Authorization", "Bearer e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6").
		when()
			.post("/public/v2/users/").
		then().log().all()
			.assertThat()
				.statusCode(201)
				.and()
				.body("name", equalTo("vindhya"))
				.extract()
					.path("id");
				
		System.out.println("user id -->" + userId);
		
		//2. get the same user and verify it: GET
		given()
		.header("Authorization", "Bearer e4b8e1f593dc4a731a153c5ec8cc9b8bbb583ae964ce650a741113091b4e2ac6")
			.when().log().all()
				.get("/public/v2/users/"+ userId)
					.then()
						.assertThat()
							.statusCode(200)
								.and()
									.body("id", equalTo(userId));
	}
	
	
	


}
