package com.smit.Hospital.Management.System.controller;


import com.smit.Hospital.Management.System.Service.DoctorService;
import com.smit.Hospital.Management.System.Service.PatientService;

import com.smit.Hospital.Management.System.dto.DoctorResponseDto;
import com.smit.Hospital.Management.System.dto.OnBoardDoctorRequestDto;
import com.smit.Hospital.Management.System.dto.PatientResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(patientService.getAllPatients(pageNumber, pageSize));
    }

    @PostMapping("/onBoardNewDoctors")
    public ResponseEntity<DoctorResponseDto> onBoardNewDoctor(@RequestBody OnBoardDoctorRequestDto
                                                                          onBoardDoctorRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.onBoardNewDoctor(onBoardDoctorRequestDto));
    }
}

