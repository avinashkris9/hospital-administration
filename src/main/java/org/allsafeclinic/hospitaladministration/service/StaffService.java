package org.allsafeclinic.hospitaladministration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.allsafeclinic.hospitaladministration.entity.Staff;
import org.allsafeclinic.hospitaladministration.exception.StaffNotFoundException;
import org.allsafeclinic.hospitaladministration.model.StaffDTO;
import org.allsafeclinic.hospitaladministration.repository.StaffRepository;
import org.allsafeclinic.hospitaladministration.util.CustomObjectMapper;
import org.allsafeclinic.hospitaladministration.util.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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





	public StaffDTO getStaffDetails(long employeeId) {

		Optional<Staff> staffDetails = staffRepository.findById(employeeId);
		if ( staffDetails.isPresent()) {

			Staff staff = staffDetails.get();

			return customObjectMapper.mapStaffEntityToStaffDTO(staff);
		}
		else
		{	
			logger.error(" User not Found !");
			throw new StaffNotFoundException(ErrorCodes.ERROR_CODES.ERR_NOT_FOUND.name());
		}

	}

	public void insertStaffDetails(StaffDTO staffDTO) {



		Staff staff = customObjectMapper.mapStaffDTO2StaffEntity(staffDTO);


		staffRepository.save(staff);

	}

	public StaffDTO updateStaffDetails(long employee_id, StaffDTO staffDTO1) {

		staffDTO1.setEmployeeNumber(employee_id);
       Optional<Staff> staff= staffRepository.findById(staffDTO1.getEmployeeNumber());


		staffRepository.save(customObjectMapper.mapStaffDTO2StaffEntity(staffDTO1));
		return staffDTO1;
	}
	
	public void deleteStaffDetails(long employeeId)
	{

		staffRepository.deleteById(employeeId);
		logger.info("Deleted user"+ employeeId);
	}
	
}
