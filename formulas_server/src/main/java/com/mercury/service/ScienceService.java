package com.mercury.service;

import com.mercury.domain.Science;

import java.util.List;

public interface ScienceService {

    Science insert(String nameScience);

    List<Science> getAll();

    Science getById(int id);

    Science getByName(String name);

    Science update(int id, String nameScience);

    void deleteById(int id);
}
