package com.mercury.rest.dto;

import com.mercury.domain.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaDto {

    private int id;

    private String name;

    private String formula;

    private ThemeDto themeDto;

    public static FormulaDto toDto(Formula formula) {
        return new FormulaDto(
                formula.getId(),
                formula.getName(),
                formula.getFormula(),
                ThemeDto.toDto(formula.getTheme())
        );
    }
}
