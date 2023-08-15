package JsonPathValidatorTest;

import static io.restassured.RestAssured.given;

// This is not for rest assured json path -- this is for jayway json path 
//in generics it is always class type  and they are non primitive data type

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonPathTest {
	
	@Test(enabled = true, priority = 1)
    public void getCountryValue() {
        // Specify the base URL and path parameter (year) for the GET call
        String baseUrl = "http://ergast.com/api/f1";
        String year = "2017";
        String url = baseUrl + "/" + year + "/circuits.json";

        // Send the GET request and extract the response
        Response response = given().get(url);

        // Extract the response body as a string
        String jsonResponse = response.getBody().asString();

        // Use JsonPath to extract the country value using the given JSONPath expression # use jsonpath.com
        List<String> countryList = JsonPath.read(jsonResponse, "$.MRData.CircuitTable.Circuits[?(@.circuitId == 'shanghai')].Location.country");

        // Print the country value
        System.out.println("Country: " + countryList);
       
    }




@Test(enabled = true, priority = 2)
public void getCircuitDataAPIWith_YearTest() {
	RestAssured.baseURI = "http://ergast.com";

	Response response = given().log().all().when().log().all().get("/api/f1/2017/circuits.json");

	String jsonResponse = response.asString();
	System.out.println(jsonResponse);

	int totalCircuits = JsonPath.read(jsonResponse, "$.MRData.CircuitTable.Circuits.length()");
	System.out.println(totalCircuits);

	List<String> countryList = JsonPath.read(jsonResponse, "$..Circuits..country");
	System.out.println(countryList.size());
	System.out.println(countryList);
	System.out.println("_____________________");

}

    

@Test(enabled = true, priority = 3)
public void getProductTest() {

	RestAssured.baseURI = "https://fakestoreapi.com";
	

	Response response = given().when().get("/products");
	
	
	System.out.println("productsvindhya ");

	String jsonResponse = response.asString();
	System.out.println(jsonResponse);

	List<Float> rateLessThanThree = JsonPath.read(jsonResponse, "$[?(@.rating.rate < 3)].rating.rate");
	System.out.println(rateLessThanThree);

	System.out.println("---------------");

	// with two attributes
	List<Map<String, Object>> jewellryList = JsonPath.read(jsonResponse,
			"$[?(@.category == 'jewelery')].[\"title\",\"price\"]");
	System.out.println(jewellryList);

	for (Map<String, Object> product : jewellryList) {
		String title = (String) product.get("title");
		Object price = (Object) product.get("price");

		System.out.println("title : " + title);
		System.out.println("price : " + price);
		System.out.println("--------");

	}
	
	System.out.println("---------------");


	// with three attributes
	List<Map<String, Object>> jewellryList2 = JsonPath.read(jsonResponse,
			"$[?(@.category == 'jewelery')].[\"title\",\"price\", \"id\"]");
	System.out.println(jewellryList);

	for (Map<String, Object> product : jewellryList2) {
		String title = (String) product.get("title");
		Object price = (Object) product.get("price");
		Integer id = (Integer) product.get("id");


		System.out.println("title : " + title);
		System.out.println("price : " + price);
		System.out.println("id : " + id);
		System.out.println("--------");

	}

}

}
