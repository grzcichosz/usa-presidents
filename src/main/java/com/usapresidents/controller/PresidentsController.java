package com.usapresidents.controller;

import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.entity.President;
import com.usapresidents.repository.PresidentsRepository;
import com.usapresidents.service.president.PresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("presidents")
@RestController
@RequiredArgsConstructor
public class PresidentsController {

    private final PresidentService presidentService;

    @GetMapping("/all")
    public List<PresidentDto> getAll() {
        return presidentService.getAllPresidents();
    }

    @PostMapping("save")
    public PresidentDto save(@RequestBody PresidentDto presidentDto) {
        return presidentService.savePresident(presidentDto);
    }

    @PutMapping("update")
    public PresidentDto update(@RequestBody PresidentDto presidentDto) {

        return presidentService.updatePresident(presidentDto);
    }

    @PatchMapping("update")
    public PresidentDto updatePartial(@RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresidentPartial(presidentDto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteByIndex(@PathVariable Long id) {
        presidentService.deletePresident(id);
    }
}



