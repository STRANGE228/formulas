package com.mercury.rest.controller;

import com.mercury.domain.Science;
import com.mercury.rest.dto.ScienceDto;
import com.mercury.service.ScienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ScienceController {

    private final ScienceService scienceService;

    @GetMapping("/science")
    public List<ScienceDto> getAllScience() {
        return scienceService.getAll()
                .stream()
                .map(ScienceDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/science")
    public ScienceDto insertScience(@RequestBody ScienceDto scienceDto) {
        Science science = scienceService.insert(ScienceDto.toDomainObject(scienceDto));
        return ScienceDto.toDto(science);
    }

    @PutMapping("/science/{id}")
    public ScienceDto updateScience(@PathVariable int id,
                                  @RequestParam String name) {
        Science science = scienceService.update(id, name);
        return ScienceDto.toDto(science);
    }

    @DeleteMapping("/science/{id}")
    public void deleteScience(@PathVariable int id) {
        scienceService.deleteById(id);
    }

    @GetMapping("/science/{id}")
    public ScienceDto getScienceById(@PathVariable int id) {
        Science science = scienceService.getById(id);
        return ScienceDto.toDto(science);
    }
}
