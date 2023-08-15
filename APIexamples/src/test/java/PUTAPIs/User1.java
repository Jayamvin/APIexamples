
package PUTAPIs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User1 {
	
	// we write jsonproperty for exact variable json look into it. you can writr any name for id but it is recognized as id in json
	
	@JsonProperty("id") 
	private Integer id;
	
	// Integer is a class the default value of the class is null.
	// if it was "int", the default value of the int is zero.
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("status")
	private String status;

	
	//Ctreate the constructor without ID 
	public User1(String name, String email, String gender, String status) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}

}
