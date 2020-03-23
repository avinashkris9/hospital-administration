package org.allsafeclinic.hospital.administration.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.allsafeclinic.hospital.administration.util.ErrorCodes;
import org.allsafeclinic.hospital.administration.entity.Patient;
import org.allsafeclinic.hospital.administration.exception.PatientNotFoundException;

import org.allsafeclinic.hospital.administration.model.PatientDTO;
import org.allsafeclinic.hospital.administration.repository.PatientRepository;
import org.allsafeclinic.hospital.administration.util.CustomObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class PatientService {
	

	Logger logger = LoggerFactory.getLogger(PatientService.class);

	private final PatientRepository patientRepository;
	private final CustomObjectMapper customObjectMapper;

	public PatientService(PatientRepository patientRepository,CustomObjectMapper customObjectMapper)
	{
		this.patientRepository=patientRepository;
		this.customObjectMapper=customObjectMapper;
	}


	/**
	 * Query for all the records in patient db.
	 *
	 *
	 *
	 * @return List of patient dto.
	 * @throws PatientNotFoundException if no record found.
	 *
	 */
	public List<PatientDTO>getAllPatientsDetails(){

		List<Patient>patientDetails= patientRepository.findAll();
		if(patientDetails.isEmpty())
		{
			throw new PatientNotFoundException(ErrorCodes.ERROR_CODES.ERR_STAFF_NOT_FOUND.name());
		}

		 return patientDetails.stream().
				 map(customObjectMapper::mapPatientEntity2patientDTO
				 ).collect(Collectors.toList());
	}

	/**
	 * Query with the given mrn for details.
	 *
	 *
	 * @param mrnumber must not be null
	 * @return patient entity;
	 * @throws PatientNotFoundException if no record found.
	 *
	 */


	public PatientDTO getPatientDetailsByMrNumber(long mrnumber) {
		
		Optional<Patient> patientDetails= patientRepository.findById(mrnumber);
		
		if(patientDetails.isPresent())
		{
			return customObjectMapper.mapPatientEntity2patientDTO(patientDetails.get());
		}

		else
		{
			throw new PatientNotFoundException(Long.toString(mrnumber));
		}
		

		
	}



	/**
	 * Update given patient if present else insert
	 *
	 *
	 * @param patientDTO must not be null
	 * @return the saved entity;
	 *
	 */
	public void insertPatientDetails(PatientDTO patientDTO)
	{
		


		patientDTO.setDateOfRegistration(LocalDate.now().toString());
		Patient patient=new Patient();
		patient=customObjectMapper.mapPatientDTO2PatientEntity(patientDTO);

		patientRepository.save(patient);

		
	}


	/**
	 * Saves given patient if present else insert
	 *
	 *
	 * @param patientDTO must not be null
	 * @return the saved entity;
	 *
	 */
	public PatientDTO updatePatientDetails(PatientDTO patientDTO)
	{
		patientRepository.save(customObjectMapper.mapPatientDTO2PatientEntity(patientDTO));
		return patientDTO;


	}
	
	
}
