package GETAPIs;

import org.testng.annotations.Test;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;


import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matcher;
import io.restassured.response.ValidatableResponse;


public class GETAPIRequestWithBDD {
	
	  @Test
	   public void getProductsTest(){
		
		
		given().log().all()
		  .when().log().all()
		     .get("https://fakestoreAPI.com/products")
		        .then().log().all()
		             .assertThat()
		                 .statusCode(200)
		                   .and()
		                      .contentType(ContentType.JSON)
		                           .and()
		                               .header("Connection","keep-alive")
		                                  .and()
		                                        .body("$.size()", equalTo(20))
		                                             .and()
		                                                .body("id", is(notNullValue()))
		                                                     .and()
		                                                        .body("title", hasItem("Mens Cotton Jacket"));
		
		
		
	  }
	  
	  // $ represents a response body in restassured. in this example $ is array thats why we used .size() method 
	  //equalTo got from hamcrest library
	  //restassured is always hard assertions once it is failed it will not beyond that point. 
	  
	  
	  @Test
	  public void getUserAPITest(){
		
		
		given().log().all()
		  .header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502")
		  .when().log().all()
		     .get("https://gorest.co.in/public/v2/users/")
		        .then().log().all()
		             .assertThat()
		                 .statusCode(200)
		                   .and()
		                      .contentType(ContentType.JSON)
		                           .and()
		                              .body("$.size()", equalTo(10)); // We use dollar sign when the response body is in array 
		                                            

	  } 
	  
	  
	  
	  @Test
	  public void getProductDataWithAPIQueryParamTest(){
		
		given().log().all()
		  .queryParam("limit", 5)
		   .queryParam("name", "Naveen")
		    .when().log().all()
		     .get("https://fakestoreAPI.com/products")
		        .then().log().all()
		             .assertThat()
		                 .statusCode(200)
		                   .and()
		                      .contentType(ContentType.JSON);
		                          
	  }
	  
	  @Test
	  public void getProductDataAPI_with_Extract_Body(){
		RestAssured.baseURI = "https://fakestoreAPI.com";
		
		     Response response = given().log().all()
		                                .queryParam("limit", 5)
		                                  .when().log().all()
		                                    .get("/products");
		                                     
		 
		
		     JsonPath js = response.jsonPath(); // it gives the complete json response and jsonpath also import from restassured.
		
		 
		     //get the id of the first product:
		     int firstProductID = js.getInt("[0].id");
		     System.out.println("firstProductID = " + firstProductID);
		
		     String firstProductTitle = js.getString("[0].title");
		     System.out.println("firstProductTitle = " + firstProductTitle);
		
		     float price = js.getFloat("[0].price");
		     System.out.println("price = " + price);
		
		     int count = js.getInt("[0].rating.count");
		     System.out.println("count = " + count);
		
		
		
	  }
	  
	  @Test
	  public void getProductDataAPI_with_Extract_Body_withJsonArray(){
		RestAssured.baseURI = "https://fakestoreAPI.com";
		
		     Response response = given().log().all()
		                                .queryParam("limit", 5)
		                                  .when().log().all()
		                                    .get("/products");
		                                     
	     
	  
		     JsonPath js = response.jsonPath();//json array want to collect all Ids 
		      
	         List<Integer> idList = js.getList("id");
	         List<String> titleList = js.getList("title");
	         List<Object> rateList = js.getList("rating.rate");
	         List<Integer> countList = js.getList("rating.count");
	         
	         for(int i=0; i<idList.size(); i++) {
	        	 int id = idList.get(i);
	        	 String title = titleList.get(i);
	        	 Object rate = rateList.get(i);
	        	 int count = countList.get(i);
	        	 System.out.println("ID:" + id + "  " +"Title:" + title+ "  " + "Rate:" + " " + rate + " " + "count:" + " " + count); 
	        	 
	        	
	         }
	         
	  
	  } 
	  
	       @Test
	        public void getUserAPI_with_Extract_Body_withJson(){
	  
	            Response response = given().log().all()
	            		               .header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502")
	            		                  .when().log().all()
	            		                      .get("https://gorest.co.in/public/v2/users/3571519");
	            
	            
	            JsonPath js = response.jsonPath();
	            
	            System.out.println(js.getInt("id"));
	            System.out.println(js.getString("email"));
	                      
	            
	       }  
	       
	       @Test
	       public void getUserAPI_with_Extract_Body_withJson_Extract(){
	 
	           int userId = given().log().all()
	           		               .header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502")
	           		                  .when().log().all()
	           		                      .get("https://gorest.co.in/public/v2/users/3571519")
	                                          .then()
	                                            .extract().path("id");
	                                         
	              
	            System.out.println(userId);   
	            
	            Response response = given().log().all()
 		               .header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502")
 		                  .when().log().all()
 		                      .get("https://gorest.co.in/public/v2/users/3571519");
	            
	            //fetch multiple values 
 
	            int user2Id = response.then().extract().path("id"); 
	            String email = response.then().extract().path("email"); 
	            
	            System.out.println(user2Id); 
	            System.out.println(email); 
	            
	            //same like above
	            
	            Response response2 = given().log().all()
	 		               .header("Authorization", "Bearer 488d579655f98cb483e6a901b3501cbf68ace89865dc309352fcaa349dfd2502")
	 		                  .when().log().all()
	 		                      .get("https://gorest.co.in/public/v2/users/3571519")
	                                  .then()
	                                     .extract()
	                                         .response();
		            
		            //fetch multiple values 
	 
		            int user3Id = response.path("id"); 
		            String email2 = response.path("email2"); 
		            
		            System.out.println(user3Id); 
		            System.out.println(email2); 
	            
	             
	       
	       }
	       
	     // path parameter is not included here  for that example look in naveen files      
		                               

	}
		
		
		




