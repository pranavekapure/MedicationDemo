package com.medication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medication.dto.MedicineDto;
import com.medication.pojo.Medicine;
import com.medication.serviceImpl.MedicationServiceImpl;

@RestController
@RequestMapping("/medicine")
public class MedicationController {
	
	@Autowired
	private MedicationServiceImpl medicationServiceImpl;
	


	@RequestMapping(method = RequestMethod.GET, path= "/getList")
	public ResponseEntity<List<Medicine>> getMedicineList() {
		
		
		return new ResponseEntity<List<Medicine>>( medicationServiceImpl.getMedicationList(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/saveMedicine")
	public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine){
		return new ResponseEntity<Medicine>(medicationServiceImpl.saveAndUpdateMedicine(medicine),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path= "/getMedicineList/{patientId}")
	public ResponseEntity<MedicineDto> getMedicineListForPatient(@PathVariable Integer patientId){
		return new ResponseEntity<MedicineDto>(medicationServiceImpl.getMedicineListForPatient(patientId),HttpStatus.OK);
		
	}

}
