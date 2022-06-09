package com.devopsi.akademia.clinic;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ClinicService {


    private PatientRepository patientRepository;

    public void registerPatient(Patient patient) {

            Tag tag = new Tag();
            tag.setName(patient.getFirstName());
            patient.setTag(tag);
            tag.setPatient(patient);
            patientRepository.save(patient);


    }




}
