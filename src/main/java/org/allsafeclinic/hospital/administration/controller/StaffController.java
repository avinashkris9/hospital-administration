package org.allsafeclinic.hospital.administration.controller;

import javax.validation.Valid;

import org.allsafeclinic.hospital.administration.model.StaffDTO;
import org.allsafeclinic.hospital.administration.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Staff Rest Controller
 * GET/PUT/DELETE/POST
 */

@RestController
@CrossOrigin
@RequestMapping("/admin/staffs")
public class StaffController
{

	
	Logger logger = LoggerFactory.getLogger(StaffController.class);

	private final StaffService staffService;


	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}



	@GetMapping()
	public List<StaffDTO> getAllStaffs()
	{
	logger.info(" Getting all info");
	return	staffService.getAllStaffDetails();

	}

	
	/**
	 * Get staff details by passing employee id as parameter
	 * @param employeeId
	 * @return staff object
	 */
	@GetMapping("/{employeeId}")
	public StaffDTO getStaffDetails(@PathVariable final long employeeId) {
		logger.info("GET request to fetch details of {}",employeeId);
		return staffService.getStaffDetails(employeeId);
	}


	/**
	 * Recieves Staff and validate
	 * @param staffDTO
	 */
	@PostMapping()
	public void addStaffDetails(@Valid @RequestBody final StaffDTO staffDTO) {
		


		staffService.insertStaffDetails(staffDTO);
	}


	/**
	 * Uodate url
	 * @param staffDTO
	 * @param employeeId
	 */
	@PutMapping("{employeeId}")
	public void updateStaffDetails(@RequestBody final StaffDTO staffDTO, @PathVariable final long employeeId)
	{


		staffService.updateStaffDetails(employeeId, staffDTO);
	}

	@DeleteMapping("{employeeId}")
	public void deleteStaffDetails(@PathVariable long employeeId)
	{
		 staffService.deleteStaffDetails(employeeId);
	}


}
