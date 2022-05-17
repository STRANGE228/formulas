package com.mercury.rest.controller;

import com.mercury.domain.Theme;
import com.mercury.rest.dto.ThemeDto;
import com.mercury.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("/theme")
    public List<ThemeDto> getAllTheme() {
        List<ThemeDto> themeDtoList = themeService.getAll()
                .stream()
                .map(ThemeDto::toDto)
                .collect(Collectors.toList());
        return themeDtoList;
    }

    @PostMapping("/theme")
    public ThemeDto insertTheme(
            @RequestParam String nameTheme,
            @RequestParam String nameScience
    ) {
        Theme theme = themeService.insert(nameTheme, nameScience);
        return ThemeDto.toDto(theme);
    }

    @PutMapping("/theme/{id}")
    public ThemeDto updateTheme(
            @PathVariable int id,
            @RequestParam String nameTheme,
            @RequestParam String nameScience
    ) {
        Theme theme = themeService.update(id, nameTheme, nameScience);
        return ThemeDto.toDto(theme);
    }

    @GetMapping("/theme/{id}")
    public ThemeDto getThemeById(@PathVariable int id) {
        return ThemeDto.toDto(themeService.getById(id));
    }

    @DeleteMapping("/theme/{id}")
    public void deleteTheme(@PathVariable int id) {
        themeService.deleteById(id);
    }
}
