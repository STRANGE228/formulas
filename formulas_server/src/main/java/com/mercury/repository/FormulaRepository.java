package com.mercury.repository;

import com.mercury.domain.Formula;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormulaRepository extends JpaRepository<Formula, Integer> {

    @Override
    @EntityGraph(attributePaths = {"theme"})
    List<Formula> findAll();

    List<Formula> findByName(String name);
}
