package com.mercury.service;

import com.mercury.domain.Formula;

import java.util.List;

public interface FormulaService {

    Formula insert(
            String nameFormula,
            String formula,
            String nameTheme
    );

    Formula update(
            int id,
            String nameFormula,
            String formula,
            String nameTheme
    );

    List<Formula> getAll();

    Formula getById(int id);

    List<Formula> getByName(String nameFormula);

    void deleteById(int id);
}
