package com.mercury.rest.controller;


import com.mercury.domain.Formula;
import com.mercury.rest.dto.FormulaDto;
import com.mercury.service.FormulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FormulaController {

    private final FormulaService formulaService;

    @GetMapping("/formula")
    public List<FormulaDto> getAllFormula() {
        List<FormulaDto> formulaDtoList = formulaService.getAll()
                .stream()
                .map(FormulaDto::toDto)
                .collect(Collectors.toList());
        return formulaDtoList;
    }

    @PostMapping("/formula")
    public FormulaDto insertFormula(
            @RequestParam String nameFormula,
            @RequestParam String formula_s,
            @RequestParam String nameTheme

    ) {
        Formula formula = formulaService.insert(nameFormula, formula_s, nameTheme);
        return FormulaDto.toDto(formula);
    }

    @PutMapping("/formula/{id}")
    public FormulaDto updateFormula(
            @PathVariable int id,
            @RequestParam String nameFormula,
            @RequestParam String formula_s,
            @RequestParam String nameTheme
    ) {
        Formula formula = formulaService.update(id, nameFormula, formula_s, nameTheme);
        return FormulaDto.toDto(formula);
    }

    @GetMapping("/formula/{id}")
    public FormulaDto getFormulaById(@PathVariable int id) {
        return FormulaDto.toDto(formulaService.getById(id));
    }

    @DeleteMapping("/formula/{id}")
    public void deleteFormula(@PathVariable int id) {
        formulaService.deleteById(id);
    }
}
