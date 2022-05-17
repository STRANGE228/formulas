package com.mercury.service;

import com.mercury.domain.Science;
import com.mercury.repository.ScienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScienceServiceImpl implements ScienceService {

    private final ScienceRepository scienceRepository;

    @Override
    public Science insert(Science science) {
        return (Science) scienceRepository.save(science);
    }

    @Override
    public List<Science> getAll() {
        return scienceRepository.findAll();
    }

    @Override
    public Science getById(int id) {
        return (Science) scienceRepository.findById(id).get();
    }

    @Override
    public Science getByName(String name) {
        return scienceRepository.findByName(name);
    }

    @Override
    public Science update(int id, String nameScience) {
        Science science = Science.builder()
                .id(id)
                .name(nameScience)
                .build();
        return (Science) scienceRepository.save(science);
    }

    @Override
    public void deleteById(int id) {
        scienceRepository.deleteById(id);
    }
}
