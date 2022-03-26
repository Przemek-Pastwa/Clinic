package com.devopsi.akademia.clinic;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClinicService {

    private final Map<String, Patient> patients;

    public ClinicService(){
        this.patients = new HashMap<>();
    }


    public void registerPatient(Patient patient) {
        if (!this.patients.containsKey(patient.getPersonalIdNumber())) {
            this.patients.put(patient.getPersonalIdNumber(), patient);
        }
    }

    public void updatePatient(String personalIdNumber, Patient patient) {
        if (this.patients.containsKey(personalIdNumber)) {
            this.patients.put(personalIdNumber, patient);
        }
    }

    public void deletePatient(String personalIdNumber) {
        this.patients.remove(personalIdNumber);
    }

    public List<Patient> getPatients() {
        List<Patient> listPatients = new ArrayList<>();
        for(String personalIdNumber: this.patients.keySet()){
            listPatients.add(this.patients.get(personalIdNumber));

        }
        return listPatients;
    }



}
