package com.fake.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductLombok {
	
	private int id;
	private String title;
	private double price;
	private String description;
	private String category;
	private String image;
	private Rating rating;
	

	// Rating class: Inner class
	@Data	
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Rating {
		private double rate;
		private int count;
	}


}
