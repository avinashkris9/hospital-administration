package org.allsafeclinic.hospital.administration.repository;

import java.util.List;

import org.allsafeclinic.hospital.administration.entity.Patient;

import org.springframework.data.repository.CrudRepository;
public interface PatientRepository  extends CrudRepository<Patient, Long> {


    @Override
    List<Patient> findAll();


    
    
    
   
}
