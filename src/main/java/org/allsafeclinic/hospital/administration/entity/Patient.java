package org.allsafeclinic.hospital.administration.entity;







import javax.persistence.*;

/**
 * Patient Data
 */
@Entity
@Table(name="patient_details")
public class Patient {

   
	 
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
    private long mrnNumber;


    private String firstName;
	private String gender;
	private String lastName;
    private String age;
    @Embedded
    private Address address;
    private String phoneNumber;
    private String email;
    private String dateOfRegistration;
    private String emergencyContact;
    
    
    
	public Patient() {

	}

	public Patient(int mrnNumber, String firstName, String gender, String lastName, String age, Address address,
				   String phoneNumber, String email, String dateOfRegistration, String emergencyContact) {
		this.mrnNumber = mrnNumber;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfRegistration = dateOfRegistration;
		this.emergencyContact = emergencyContact;
	}

	public long getMrnNumber() {
		return mrnNumber;
	}

	public void setMrnNumber(long mrnNumber) {
		this.mrnNumber = mrnNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
 
}