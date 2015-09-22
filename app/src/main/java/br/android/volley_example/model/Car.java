package br.android.volley_example.model;

/**
 * Car.java class.
 * 
 * @author Rodrigo Cericatto
 * @since 15/10/2014
 */
public class Car {
	
	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	
	private String name;
	private String imageUrl;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Car() {}
	
	public Car(String name, String imageUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	//--------------------------------------------------
	// To String
	//--------------------------------------------------
	
	@Override
	public String toString() {
		return "Car [nome=" + name + ", imageUrl=" + imageUrl + "]";
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}