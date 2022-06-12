package com.devopsi.akademia.clinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String disease;

    @ManyToMany
    @JoinTable(
            name = "users_diseases",
            joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients = new HashSet<>();

    public void addDisease(Patient patient) {
        patients.add(patient);
    }
}
