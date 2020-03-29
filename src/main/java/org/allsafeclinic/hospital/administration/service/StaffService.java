package org.allsafeclinic.hospital.administration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.allsafeclinic.hospital.administration.repository.StaffRepository;
import org.allsafeclinic.hospital.administration.util.ErrorCodes;
import org.allsafeclinic.hospital.administration.entity.Staff;
import org.allsafeclinic.hospital.administration.exception.StaffNotFoundException;
import org.allsafeclinic.hospital.administration.model.StaffDTO;
import org.allsafeclinic.hospital.administration.util.CustomObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class StaffService {


	Logger logger = LoggerFactory.getLogger(StaffService.class);
	private final StaffRepository staffRepository;
	private final CustomObjectMapper customObjectMapper;




	public StaffService(StaffRepository staffRepository,CustomObjectMapper customObjectMapper) {
		this.staffRepository = staffRepository;
		this.customObjectMapper = customObjectMapper;
	}




public List<StaffDTO> getAllStaffDetails()
{

	List<Staff> staffDAOs=staffRepository.findAll();
	List<StaffDTO> staffDTOs=new ArrayList();
	if(staffDAOs.isEmpty())
	{
		throw new StaffNotFoundException(ErrorCodes.ERROR_CODES.ERR_STAFF_NOT_FOUND.name());

	}
	else
	{
		for(Staff x:staffDAOs)
		{
			staffDTOs.add(customObjectMapper.mapStaffEntityToStaffDTO(x));
		}
		return  staffDTOs;
	}
}
	public StaffDTO getStaffDetails(long employeeId) {

		Optional<Staff> staffDetails = staffRepository.findById(employeeId);
		if ( staffDetails.isPresent()) {

			Staff staff = staffDetails.get();

			return customObjectMapper.mapStaffEntityToStaffDTO(staff);
		}
		else
		{	
			logger.error(" User not Found !");
			throw new StaffNotFoundException(ErrorCodes.ERROR_CODES.ERR_STAFF_NOT_FOUND.name());
		}

	}

	public void insertStaffDetails(StaffDTO staffDTO) {



		Staff staff = customObjectMapper.mapStaffDTO2StaffEntity(staffDTO);


		staffRepository.save(staff);

	}

	public StaffDTO updateStaffDetails(long employee_id, StaffDTO staffDTO1) {

		staffDTO1.setEmployeeNumber(employee_id);



		staffRepository.save(customObjectMapper.mapStaffDTO2StaffEntity(staffDTO1));
		return staffDTO1;
	}
	
	public void deleteStaffDetails(long employeeId)
	{

		staffRepository.deleteById(employeeId);
		logger.info("Deleted user"+ employeeId);
	}
	
}
