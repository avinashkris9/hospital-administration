package org.allsafeclinic.hospitaladministration.repository;

import java.util.List;

import org.allsafeclinic.hospitaladministration.entity.Staff;
import org.springframework.data.repository.CrudRepository;
public interface StaffRepository  extends CrudRepository<Staff, Long> {

	

    @Override
    List<Staff> findAll();



    List<Staff> findByFirstNameIgnoreCase (String firstName);
   
}
