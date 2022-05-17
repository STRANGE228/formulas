package com.mercury.repository;


import com.mercury.domain.Science;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScienceRepository extends JpaRepository<Science, Integer> {

   Science findByName(String name);

}
