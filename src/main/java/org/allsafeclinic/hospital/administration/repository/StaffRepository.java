package org.allsafeclinic.hospital.administration.repository;

import java.util.List;

import org.allsafeclinic.hospital.administration.entity.Staff;
import org.springframework.data.repository.CrudRepository;
public interface StaffRepository  extends CrudRepository<Staff, Long> {

	

    @Override
    List<Staff> findAll();



    List<Staff> findByFirstNameIgnoreCase (String firstName);
   
}
