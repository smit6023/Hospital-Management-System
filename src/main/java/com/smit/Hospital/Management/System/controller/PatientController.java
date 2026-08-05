package com.smit.Hospital.Management.System.controller;

import com.smit.Hospital.Management.System.Service.AppointmentService;
import com.smit.Hospital.Management.System.Service.PatientService;
import com.smit.Hospital.Management.System.dto.AppointmentResponseDto;
import com.smit.Hospital.Management.System.dto.CreateAppointmentRequestDto;
import com.smit.Hospital.Management.System.dto.PatientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto
                                                                                   createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile() {
        Long patientId = 4L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
}
