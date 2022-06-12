package com.devopsi.akademia.clinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Referral {

    @Id
    @GeneratedValue
    private Long id;
    private String medicalSpecialist;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;


    public void addReferral(Patient patient) {
        this.patient = patient;
    }
}
