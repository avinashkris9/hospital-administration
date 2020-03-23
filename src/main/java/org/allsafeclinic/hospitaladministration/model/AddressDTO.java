package org.allsafeclinic.hospitaladministration.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddressDTO {

	
	@NotBlank
	private String houseName;
	private String streetName;
	@NotBlank
	private String place;
	@NotBlank
	private String city;
	@NotBlank
	private String state;;
	@NotBlank
	@Size(min=6, max=6, message="Invalid Pincode. Length verification failed")
	private String pinCode;
	
	 public AddressDTO()
	
	{
		
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(final String houseName) {
		this.houseName = houseName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(final String streetName) {
		this.streetName = streetName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(final String place) {
		this.place = place;
	}
	public String getCity() {
		return city;
	}
	public void setCity(final String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(final String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(	 String pinCode){
		this.pinCode = pinCode;
	}
	public AddressDTO(final String houseName, final String streetName, final String place, final String city, final String state, String pinCode) {
		super();
		this.houseName = houseName;
		this.streetName = streetName;
		this.place = place;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	
	
}
