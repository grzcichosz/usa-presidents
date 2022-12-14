package com.usapresidents.controller;

import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.entity.President;
import com.usapresidents.repository.PresidentsRepository;
import com.usapresidents.service.president.PresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("presidents")
@RestController
@RequiredArgsConstructor
public class PresidentsController {

    private final PresidentService presidentService;

    @GetMapping("/all")
    public List<PresidentDto> getAll() {
        return presidentService.getAllPresidents();
    }

    @GetMapping ("find-by-name/{name}")
    public Set<PresidentDto> findPresidentByName(@PathVariable String name){
        return presidentService.findPresidentsByName(name);
    }

    @GetMapping ("find-by-party/{party}")
    public Set<PresidentDto> findPresidentByPoliticalParty(@PathVariable String party){
        return presidentService.findPresidentsByPoliticalParty(party);
    }

    @PostMapping("save")
    public PresidentDto save(@RequestBody PresidentDto presidentDto) {
        return presidentService.savePresident(presidentDto);
    }

    @PutMapping("update")
    public PresidentDto update(@RequestBody PresidentDto presidentDto) {

        return presidentService.updatePresident(presidentDto);
    }

//    @ExceptionHandler({RuntimeException.class, IllegalAccessError.class})
//    public final ResponseEntity<Object> handleExceptions(Exception ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PatchMapping("update")
    public PresidentDto updatePartial(@RequestBody PresidentDto presidentDto) {
        return presidentService.updatePresidentPartial(presidentDto);
    }


    @DeleteMapping("delete/{id}")
    public void deleteByIndex(@PathVariable Long id) {
        presidentService.deletePresident(id);
    }


}



