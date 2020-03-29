package org.allsafeclinic.hospital.administration.controller;


import org.allsafeclinic.hospital.administration.model.PatientDTO;
import org.allsafeclinic.hospital.administration.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Map all patient related http requests.
 * GET/PUT/POST
 *
 */

@RestController

@RequestMapping("/patients")
public class PatientController {



    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    /**
     *
     *
     * @return List object of patients
     * @exception  if no patient object found
     */
    @GetMapping()
    public List<PatientDTO> getAllPatientDetails()
    {

        return patientService.getAllPatientsDetails();

    }


    /**
     *
     *
     * @param medicalRecordNumber
     * @return PatientObject
     * @exception  if no patient found
     */
    @GetMapping("/{medicalRecordNumber}")
    public PatientDTO getStaffDetails(@PathVariable long medicalRecordNumber)
    {
        return patientService.getPatientDetailsByMrNumber(medicalRecordNumber);

    }


    /**
     *
     * @param patientDTO
     * validate the patientObject
     * @exception  if validation fails
     */
    @PostMapping()
    public void addPatientDetails(@RequestBody @Valid PatientDTO patientDTO)
    {

        patientService.insertPatientDetails(patientDTO);
    }

    /**
     *
     *
     * @param patientDTO
     * validate patient object
     *
     */
    @PutMapping()
    public void updatePatientDetails(@RequestBody  @Valid  PatientDTO patientDTO)
    {

        patientService.updatePatientDetails(patientDTO);
    }
}
