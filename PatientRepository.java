package com.devopsi.akademia.clinic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
}
