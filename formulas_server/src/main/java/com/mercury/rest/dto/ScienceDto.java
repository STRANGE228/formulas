package com.mercury.rest.dto;

import com.mercury.domain.Science;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScienceDto {

    private int id;

    private String name;

    public static ScienceDto toDto(Science science) {
        return new ScienceDto(
                science.getId(),
                science.getName()
        );
    }

    public static Science toDomainObject(ScienceDto scienceDto) {
        return new Science(
                scienceDto.getId(),
                scienceDto.getName()
        );
    }
}
