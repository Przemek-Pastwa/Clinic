package com.devopsi.akademia.clinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotEmpty
    private String firstName;
    private String surName;
    @Size(min = 11, max = 11)
    private String personalIdNumber;
    private int phoneNumber;
    private String comments;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Tag tag;


}
