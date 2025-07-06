package com.dharmaraj.e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.e_commerce.models.Preference;

@Repository
public interface PreferencesRepository extends JpaRepository<Preference, Integer> {

}
