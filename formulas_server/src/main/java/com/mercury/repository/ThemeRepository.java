package com.mercury.repository;

import com.mercury.domain.Theme;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {

    @Override
    @EntityGraph(attributePaths = {"science"})
    List<Theme> findAll();

    Theme findByName(String name);
}
