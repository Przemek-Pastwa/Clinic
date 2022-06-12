package com.devopsi.akademia.clinic;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;


@Service
@AllArgsConstructor
public class ClinicService {


    private PatientRepository patientRepository;
    private ReferralRepository referralRepository;
    private DiseaseRepository diseaseRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void registerPatient(Patient patient) {

        Tag tag = new Tag();
        tag.setName(patient.getFirstName());
        patient.setTag(tag);
        tag.setPatient(patient);
        patientRepository.save(patient);

    }

    public List<Patient> getAllPatients(){
        return jdbcTemplate.query("SELECT id, first_name, sur_name, personal_id_number, phone_number, comments FROM patient",
            BeanPropertyRowMapper.newInstance(Patient.class));
    }

    public List<Tag> getAllTags(){
        return jdbcTemplate.query("SELECT id, name FROM tag",
            BeanPropertyRowMapper.newInstance(Tag.class));
    }

    public List<Disease> getDisease(){
        return jdbcTemplate.query("SELECT id, disease FROM disease",
                BeanPropertyRowMapper.newInstance(Disease.class));
    }

    public Patient getPatientById(Long id){
        return  jdbcTemplate.queryForObject("SELECT id, first_name, sur_name, personal_id_number, phone_number, comments FROM patient WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Patient.class), id);
    }

    public void deletePatient(Long id) {
        jdbcTemplate.update("DELETE FROM tag WHERE patient_id = ?", id);
        jdbcTemplate.update("DELETE FROM patient WHERE id = ?", id);
    }



}

