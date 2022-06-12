package com.devopsi.akademia.clinic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String surName;
    @Size(min = 11, max = 11)
    private String personalIdNumber;
    private int phoneNumber;
    private String comments;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Tag tag;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Referral> referrals = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "patients", cascade = CascadeType.ALL)
    private Set<Disease> diseases = new HashSet<>();


}
