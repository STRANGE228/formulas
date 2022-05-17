package com.mercury.service;

import com.mercury.domain.Theme;

import java.util.List;

public interface ThemeService {

    Theme insert(
            String nameTheme,
            String nameScience
    );

    Theme update(
            int id,
            String nameTheme,
            String nameScience
    );

    List<Theme> getAll();

    Theme getById(int id);

    List<Theme> getByName(String nameTheme);

    void deleteById(int id);
}
