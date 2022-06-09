package com.devopsi.akademia.clinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor

public class ClinicController {
    
    private final ClinicService clinicService;


    @PostMapping("/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid Patient patient){
        this.clinicService.registerPatient(patient);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

}
