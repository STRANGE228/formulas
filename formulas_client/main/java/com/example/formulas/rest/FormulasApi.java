package com.example.formulas.rest;

import com.example.formulas.domain.Formula;
import com.example.formulas.domain.Science;
import com.example.formulas.domain.Theme;

public interface FormulasApi {

    void fillFormula();

    void fillTheme();

    void fillScience();

    void addFormula(Formula formula);

    void updateFormula(
            int id,
            String newFormulaName,
            String newFormula,
            String newThemeName
    );

    void deleteFormula(int id);

    void addScience(
            Science science
    );

    void updateScience(
            int id,
            String nameScience
    );

    void deleteScience(int id);

    void addTheme(
            Theme theme
    );

    void updateTheme(
            int id,
            String nameTheme,
            String nameScience
    );

    void deleteTheme(int id);
}
