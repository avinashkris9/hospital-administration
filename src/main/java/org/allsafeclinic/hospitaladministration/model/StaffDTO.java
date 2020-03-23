package org.allsafeclinic.hospitaladministration.model;

import org.allsafeclinic.hospitaladministration.util.ErrorCodes;
import org.allsafeclinic.hospitaladministration.util.IsValidGender;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * Staff
 */
public class StaffDTO {

    
    private long employeeNumber;
	@NotBlank()
	private String age;
	 @NotNull @Valid
	private AddressDTO address;
	@IsValidGender(enumClass = ErrorCodes.Gender.class) @NotBlank
	private String gender;
	@Size(min = 10, max = 11, message= ErrorCodes.INVALID_PHONE)
	private String phoneNumber;
	@Email(message = ErrorCodes.INVALID_EMAIL)
	private String email;
	@NotBlank()
	private String firstName;
	@NotBlank()
	private String lastName;
    private String department;
    
    public StaffDTO() {
    
    }
    
	
	public StaffDTO(long employeeNumber, String firstName, String lastName, String age, AddressDTO address, String phoneNumber, String email,
					String department, String gender) {
	
	this.employeeNumber = employeeNumber;
	this.firstName = firstName;
	this.lastName=lastName;
	this.age = age;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.department = department;
	this.gender=gender;
	
}


	
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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