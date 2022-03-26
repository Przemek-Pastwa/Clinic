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
    @PutMapping("/patients/{personalIdNumber}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String personalIdNumber, @RequestBody Patient patient){
        this.clinicService.updatePatient(personalIdNumber, patient);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(patient);
    }
    @DeleteMapping("/patients/{personalIdNumber}")
    public ResponseEntity<Void> deletePatient(@PathVariable String personalIdNumber){
        this.clinicService.deletePatient(personalIdNumber);
        return  ResponseEntity.status(HttpStatus.OK)
                .build();
    }
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = this.clinicService.getPatients();
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }

}
