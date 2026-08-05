package com.smit.Hospital.Management.System.Service;

import com.smit.Hospital.Management.System.Entity.Insurance;
import com.smit.Hospital.Management.System.Entity.Patient;
import com.smit.Hospital.Management.System.Repository.InsuranceRepository;
import com.smit.Hospital.Management.System.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Patient not found with id : "+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);  // bidirectional consistency maintenance
        return patient;
    }
     @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Patient not found with id : "+patientId));
        patient.setInsurance(null);
        return patient;
    }

}
