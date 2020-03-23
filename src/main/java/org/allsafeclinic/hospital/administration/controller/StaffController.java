package org.allsafeclinic.hospital.administration.controller;

import javax.validation.Valid;

import org.allsafeclinic.hospital.administration.model.StaffDTO;
import org.allsafeclinic.hospital.administration.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Staff Rest Controller
 * GET/PUT/DELETE/POST
 */

@RestController

@RequestMapping("/admin/staffs")
public class StaffController
{

	
	Logger logger = LoggerFactory.getLogger(StaffController.class);

	private final StaffService staffService;


	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}


	/**
	 * Get staff details by passing employee id as parameter
	 * @param employeeId
	 * @return
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
