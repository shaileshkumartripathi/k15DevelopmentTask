package com.k15t.pat.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm, Long> {
}
