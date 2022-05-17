package com.mercury.service;


import com.mercury.domain.Formula;
import com.mercury.domain.Science;
import com.mercury.domain.Theme;
import com.mercury.repository.FormulaRepository;
import com.mercury.repository.ScienceRepository;
import com.mercury.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormulaServiceImpl implements FormulaService{

    private final FormulaRepository formulaRepository;

    private final ThemeRepository themeRepository;

    private final ScienceRepository scienceRepository;


    @Override
    public Formula insert(String nameFormula, String formula_s, String nameTheme) {
        Theme theme = themeRepository.findByName(nameTheme);

        if (theme == null) {
            Science science = scienceRepository.findByName("неизвестно");
            theme = Theme.builder()
                    .name(nameTheme)
                    .science(science)
                    .build();
            themeRepository.save(theme);
        }

        Formula formula = Formula.builder()
                .name(nameFormula)
                .formula(formula_s)
                .theme(theme)
                .build();

        return (Formula) formulaRepository.save(formula);
    }

    @Override
    public Formula update(int id, String nameFormula, String formula_s, String nameTheme) {
        Theme theme = themeRepository.findByName(nameTheme);

        if (theme == null) {
            Science science = scienceRepository.findByName("неизвестно");
            theme = Theme.builder()
                    .name(nameTheme)
                    .science(science)
                    .build();
            themeRepository.save(theme);
        }

        Formula formula = Formula.builder()
                .name(nameFormula)
                .formula(formula_s)
                .theme(theme)
                .build();

        return (Formula) formulaRepository.save(formula);
    }

    @Override
    public List<Formula> getAll() {
        return formulaRepository.findAll();
    }

    @Override
    public Formula getById(int id) {
        return (Formula) formulaRepository.getById(id);
    }

    @Override
    public List<Formula> getByName(String nameFormula) {
        return formulaRepository.findByName(nameFormula);
    }

    @Override
    public void deleteById(int id) {
        formulaRepository.deleteById(id);
    }
}
