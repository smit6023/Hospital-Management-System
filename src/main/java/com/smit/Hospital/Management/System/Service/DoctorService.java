package com.smit.Hospital.Management.System.Service;

import com.smit.Hospital.Management.System.Entity.Doctor;
import com.smit.Hospital.Management.System.Entity.User;
import com.smit.Hospital.Management.System.Entity.type.RoleType;
import com.smit.Hospital.Management.System.Repository.DoctorRepository;
import com.smit.Hospital.Management.System.Repository.UserRepository;
import com.smit.Hospital.Management.System.dto.DoctorResponseDto;
import com.smit.Hospital.Management.System.dto.OnBoardDoctorRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRespository;

    public List<DoctorResponseDto> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnBoardDoctorRequestDto onBoardDoctorRequestDto) {
        User user = userRespository.findById(onBoardDoctorRequestDto.getUserId()).orElseThrow();

        if(doctorRepository.existsById(onBoardDoctorRequestDto.getUserId())){
            throw new IllegalArgumentException("Already a Doctor");
        }

        Doctor doctor = Doctor.builder()
                .name(onBoardDoctorRequestDto.getName())
                .specialization(onBoardDoctorRequestDto.getSpecialization())
                .user(user)
                .build();

        user.getRoles().add(RoleType.DOCTOR);

        return modelMapper.map(doctorRepository.save(doctor), DoctorResponseDto.class);

    }
}

