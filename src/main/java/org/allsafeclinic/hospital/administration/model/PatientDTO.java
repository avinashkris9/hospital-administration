package org.allsafeclinic.hospital.administration.model;



import org.allsafeclinic.hospital.administration.util.ErrorCodes;
import org.allsafeclinic.hospital.administration.util.IsValidGender;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PatientDTO {

    

    private long mrnNumber;
    
    
    private String dateOfRegistration;
    private String emergencyContact;
	
	@NotBlank
	private String age;
	@Valid
	@NotNull
	private AddressDTO address;
	@IsValidGender(enumClass = ErrorCodes.Gender.class)
	private String gender;
	@Size(min = 10, max = 11, message=ErrorCodes.INVALID_PHONE)
	private String phoneNumber;
	@Email(message = ErrorCodes.INVALID_EMAIL)
	private String email;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	public  PatientDTO()
	{

	}
	public PatientDTO(int mrnNumber, String dateOfRegistration, String emergencyContact,
					  String age, AddressDTO address, String gender, String phoneNumber, String email, String firstName, String lastName) {
		this.mrnNumber = mrnNumber;
		this.dateOfRegistration = dateOfRegistration;
		this.emergencyContact = emergencyContact;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getMrnNumber() {
		return mrnNumber;
	}

	public void setMrnNumber(long mrnNumber) {
		this.mrnNumber = mrnNumber;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}