package com.devopsi.akademia.clinic;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Patient {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String surName;
    @Size(min = 11, max = 11)
    private String personalIdNumber;
    private int phoneNumber;
    private String comments;


}
