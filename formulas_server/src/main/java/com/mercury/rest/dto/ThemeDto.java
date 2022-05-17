package com.mercury.rest.dto;

import com.mercury.domain.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThemeDto {

    private int id;

    private String name;

    private ScienceDto scienceDto;

    public static ThemeDto toDto(Theme theme) {

        return new ThemeDto(
                theme.getId(),
                theme.getName(),
                ScienceDto.toDto(theme.getScience())
        );
    }

    public static Theme toDomainObject(ThemeDto themeDto) {

        return new Theme(
                themeDto.getId(),
                themeDto.getName(),
                ScienceDto.toDomainObject(themeDto.getScienceDto())
        );
    }
}
