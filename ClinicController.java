package com.devopsi.akademia.clinic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Ref;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor

public class ClinicController {
    
    private final ClinicService clinicService;

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ReferralRepository referralRepository;
    @Autowired
    DiseaseRepository diseaseRepository;


    @PostMapping("/patients")
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid Patient patient){
        this.clinicService.registerPatient(patient);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/diseases")
    Disease createDisease(@RequestBody Disease disease){
        return diseaseRepository.save(disease);

    }

    @PostMapping("/referrals")
    Referral createReferral(@RequestBody Referral referral){
        return referralRepository.save(referral);

    }

    @GetMapping("/diseases")
    public ResponseEntity<List<Disease>> getDisease(){
        List<Disease> diseases = this.clinicService.getDisease();
        return ResponseEntity.status(HttpStatus.OK)
                .body(diseases);
    }

    @PutMapping("/{diseaseId}/patient/{patientId}")
    Disease addDiseaseToPatient(
            @PathVariable Long diseaseId,
            @PathVariable Long patientId){
        Disease disease = diseaseRepository.findById(diseaseId).get();
        Patient patient = patientRepository.findById(patientId).get();
        disease.addDisease(patient);
        return diseaseRepository.save(disease);
    }

    @PutMapping("/{patientId}/referral/{referralId}")
    Referral addReferralToPatient(
            @PathVariable Long referralId,
            @PathVariable Long patientId){
        Referral referral = referralRepository.findById(referralId).get();
        Patient patient = patientRepository.findById(patientId).get();
        referral.addReferral(patient);
        return referralRepository.save(referral);
    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = this.clinicService.getAllPatients();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }


    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> getAllTags(){
        List<Tag> tags = this.clinicService.getAllTags();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(tags);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<List<Patient>> getPatientById(@PathVariable("id") Long id){
        List<Patient> patients = Collections.singletonList(this.clinicService.getPatientById(id));
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long id){
        this.clinicService.deletePatient(id);
        return  ResponseEntity.status(HttpStatus.OK)
                .build();
    }

}
