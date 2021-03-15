package com.medication.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medication.pojo.Medicine;

public interface IMedicationService extends JpaRepository<Medicine, Integer>{

}
