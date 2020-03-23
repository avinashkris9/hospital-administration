package org.allsafeclinic.hospitaladministration.entity;



import org.allsafeclinic.hospitaladministration.model.AddressDTO;


import javax.persistence.*;

/**
 * Staff
 */

@Entity

		@Table(name="STAFF_DETAILS")
public class Staff {

    
	 @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	 private long employeeNumber;
	

	private String firstName;
	private String lastName;
    private String age;
	@Embedded
    private Address address;
    private String phoneNumber;
    private String email;
	private String department;
	private char gender;

	public Staff()
	{}
	

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public Staff(long employeeNumber, String firstName, String lastName, String age, Address address,
				 String phoneNumber, String email, String department, char gender) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.department = department;
		this.gender = gender;
	}
   
    
}