package com.mercury.service;

import com.mercury.domain.Theme;
import com.mercury.domain.Science;
import com.mercury.repository.ScienceRepository;
import com.mercury.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService{

    private final ThemeRepository themeRepository;

    private final ScienceRepository scienceRepository;

    @Override
    public Theme insert(String nameTheme, String nameScience) {
        Science science = scienceRepository.findByName(nameScience);

        if (science == null) {
            science = Science.builder()
                    .name(nameScience)
                    .build();
            scienceRepository.save(science);
        }

        Theme theme = Theme.builder()
                .name(nameTheme)
                .science(science)
                .build();

        return (Theme) themeRepository.save(theme);
    }

    @Override
    public Theme update(int id, String nameTheme, String nameScience) {
        Science science = scienceRepository.findByName(nameScience);

        if (science == null) {
            science = Science.builder()
                    .name(nameScience)
                    .build();
            scienceRepository.save(science);
        }

        Theme theme = Theme.builder()
                .id(id)
                .name(nameTheme)
                .science(science)
                .build();

        return (Theme) themeRepository.save(theme);
    }

    @Override
    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme getById(int id) {
        return (Theme) themeRepository.getById(id);
    }

    @Override
    public List<Theme> getByName(String nameTheme) {
        return (List<Theme>) themeRepository.findByName(nameTheme);
    }

    @Override
    public void deleteById(int id) {
        themeRepository.deleteById(id);
    }
}
