package GETAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Header;


public class GETAPIRequestTest {
	
RequestSpecification request;
	
	//NON BDD APPROACH
	
	@BeforeTest
	 public void setup() {
		RestAssured.baseURI = "https://gorest.co.in";
		request = RestAssured.given();
		request.header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502");
		
	}
	
    @Test
	public void getAllUserAPITest(){
    	
    	//Request
		
		Response response = request.get("/public/v2/users/");
				
		//=========================
		//status code:
		int statusCode = response.statusCode();
		System.out.println("status code: " + statusCode);
		
		//verification point:
		Assert.assertEquals(statusCode, 200);
		
		//status mesg:
		String statusMesg = response.statusLine();
		System.out.println(statusMesg);
		
		//fetch the body:
		response.prettyPrint();
		
		//fetch headers
		String contentType = response.header("content-type");
		System.out.println(contentType);
		
		//fetch all headers
		List<Header>headersList = response.headers().asList();
		System.out.println(headersList.size());
		 
		for(Header h : headersList) {
			System.out.println(h.getName()+ ":" +h.getValue());
			
		}
		
	}
	
    @Test
	public void getAllUserWithQueryParamenterAPITest(){
    	
    	//Request:
		
		request.queryParam("name", "naveen");
		request.queryParam("status", "active");
			
		Response response = request.get("/public/v2/users");
				
		//=========================
		//status code:
		int statusCode = response.statusCode();
		System.out.println("status code: " + statusCode);
		
		//verification point:
		Assert.assertEquals(statusCode, 200);
		
		//status mesg:
		String statusMesg = response.statusLine();
		System.out.println(statusMesg);
		
		//fetch the body:
		response.prettyPrint();
					
		}
		                
       @Test
       public void getAllUserWithQueryParamenters_withHashMap_APITest(){
    	   
    	    //Request
    	   
	          Map<String,String> queryParamsMap = new HashMap<String, String>();
	          
	          queryParamsMap.put("name", "naveen");
	          queryParamsMap.put("gender", "male");
	          
	          request.queryParams(queryParamsMap);
	
	          Response response = request.get("/public/v2/users");
	
	
	     //=========================
	     //status code:
	     int statusCode = response.statusCode();
	     System.out.println("status code: " + statusCode);
	     
	     //verification point:
	     Assert.assertEquals(statusCode, 200);
	
	     //status mesg:
	     String statusMesg = response.statusLine();
	     System.out.println(statusMesg);
	
	     //fetch the body:
	     response.prettyPrint();
	
		
	}
	
}


