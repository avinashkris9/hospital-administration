package org.allsafeclinic.hospital.administration.util;

import org.allsafeclinic.hospital.administration.entity.Address;
import org.allsafeclinic.hospital.administration.entity.Staff;
import org.allsafeclinic.hospital.administration.model.StaffDTO;
import org.allsafeclinic.hospital.administration.entity.Patient;
import org.allsafeclinic.hospital.administration.model.AddressDTO;
import org.allsafeclinic.hospital.administration.model.PatientDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectMapper {


    public AddressDTO mapAddressEntity2AddressDTO(Address address)
    {
        AddressDTO addressDTO=new AddressDTO();
        addressDTO.setCity(address.getCity());
        addressDTO.setHouseName(address.getHouseName());
        addressDTO.setPinCode(address.getPinCode());
        addressDTO.setPlace(address.getPlace());
        addressDTO.setState(address.getState());
        return  addressDTO;
    }

    public Address mapAddressDTO2AddressEntity(AddressDTO addressDTO)
    {
        Address address=new Address();
        address.setCity(addressDTO.getCity());
        address.setHouseName(addressDTO.getHouseName());
        address.setPinCode(addressDTO.getPinCode());
        address.setPlace(addressDTO.getPlace());
        address.setState(addressDTO.getState());

        return  address;
    }

    public Staff mapStaffDTO2StaffEntity(StaffDTO staffDTO)
    {
        
        Staff staff=new Staff();
        staff.setEmployeeNumber(staffDTO.getEmployeeNumber());
        staff.setAge(staffDTO.getAge());
        staff.setDepartment(staffDTO.getDepartment());
        staff.setEmail(staffDTO.getEmail());
        staff.setFirstName(staffDTO.getFirstName());
        staff.setDepartment(staffDTO.getDepartment());
        staff.setPhoneNumber(staffDTO.getPhoneNumber());
        staff.setLastName(staffDTO.getLastName());
        Address address=mapAddressDTO2AddressEntity(staffDTO.getAddress());
        staff.setGender(staffDTO.getGender().charAt(0));
        staff.setAddress(address);
        return staff;
    }

    public StaffDTO mapStaffEntityToStaffDTO(Staff staff)
    {


        StaffDTO staffDTO=new StaffDTO();
        staffDTO.setEmployeeNumber(staff.getEmployeeNumber());
        staffDTO.setAge(staff.getAge());
        staffDTO.setDepartment(staff.getDepartment());
        staffDTO.setEmail(staff.getEmail());
        staffDTO.setFirstName(staff.getFirstName());
        staffDTO.setDepartment(staff.getDepartment());
        staffDTO.setPhoneNumber(staff.getPhoneNumber());
        staffDTO.setLastName(staff.getLastName());
        staffDTO.setAddress(mapAddressEntity2AddressDTO(staff.getAddress()));
        staffDTO.setGender(String.valueOf(staff.getGender()));
        return staffDTO;
    }

    public PatientDTO mapPatientEntity2patientDTO(Patient patient)
    {
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setAge(patient.getAge());
        patientDTO.setEmergencyContact(patient.getEmail());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setMrnNumber(patient.getMrnNumber());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        patientDTO.setAddress(mapAddressEntity2AddressDTO(patient.getAddress()));
        patientDTO.setDateOfRegistration(patient.getDateOfRegistration());
        patientDTO.setEmergencyContact(patient.getEmergencyContact());
        return patientDTO;

    }

    public Patient mapPatientDTO2PatientEntity(PatientDTO patientDTO)
    {
        Patient patient=new Patient();
        patient.setAge(patientDTO.getAge());
        patient.setEmergencyContact(patientDTO.getEmail());
        patient.setEmail(patientDTO.getEmail());
        patient.setMrnNumber(patientDTO.getMrnNumber());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setGender(patientDTO.getGender());
        patient.setLastName(patientDTO.getLastName());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(mapAddressDTO2AddressEntity(patientDTO.getAddress()));
        patient.setDateOfRegistration(patientDTO.getDateOfRegistration());
        patient.setEmergencyContact(patientDTO.getEmergencyContact());
        return patient;

    }

}
