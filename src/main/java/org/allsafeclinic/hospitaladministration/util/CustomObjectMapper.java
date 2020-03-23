package org.allsafeclinic.hospitaladministration.util;

import org.allsafeclinic.hospitaladministration.entity.Address;
import org.allsafeclinic.hospitaladministration.entity.Staff;
import org.allsafeclinic.hospitaladministration.model.AddressDTO;
import org.allsafeclinic.hospitaladministration.model.StaffDTO;
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

}
