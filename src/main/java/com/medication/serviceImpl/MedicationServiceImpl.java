package com.medication.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medication.dto.MedicineDto;
import com.medication.pojo.Medicine;
import com.medication.service.IMedicationService;

@Service
public class MedicationServiceImpl {

	@Autowired
	private IMedicationService medicationService;

	public List<Medicine> getMedicationList() {
		List<Medicine> medicationList = medicationService.findAll();
		return medicationList;
	}

	public Medicine saveAndUpdateMedicine(Medicine medicine) {
		Medicine savedMedicine = medicationService.save(medicine);
		return savedMedicine;
	}

	public MedicineDto getMedicineListForPatient(Integer patientId) {
		MedicineDto medicineDto=new MedicineDto();
		medicineDto.setListOfMedicine(getMapOfListOfMedicine().get(patientId));
		return medicineDto;
	}

	private Map<Integer, List<Medicine>> getMapOfListOfMedicine() {
		List<Medicine> medicineList = getMedicationList();
		return medicineList.stream().collect(Collectors.groupingBy(Medicine::getPatientId));
	}

}
