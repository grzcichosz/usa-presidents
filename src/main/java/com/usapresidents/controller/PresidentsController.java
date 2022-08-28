package com.usapresidents.controller;

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
    public List<President> getAll() {
        return presidentService.getAllPresidents();
    }

    @PostMapping("save")
    public President save(@RequestBody President president) {


        return presidentService.savePresident(president);
    }
//
//    @PutMapping("update")
//    public String updateWithBodyOnly(@RequestBody President president) {
//        if (PresidentsDB.presidentRepository.size() - 1 < president.getId()) {
//            president.setId((long) PresidentsDB.presidentRepository.size());
//            PresidentsDB.presidentRepository.add(president);
//        } else {
//            PresidentsDB.presidentRepository.set(president.getId().intValue(), president);
//        }
//        return "Updated";
//    }
//
//    @PatchMapping("update")
//    public String updatePartial(@RequestBody President president) {
//        President p = PresidentsDB.presidentRepository.get(president.getId().intValue());
//        if (president.getName() != null) {
//            p.setName(president.getName());
//        }
//        if (president.getSurname() != null) {
//            p.setSurname(president.getSurname());
//        }
//        if (president.getTermFrom() != null) {
//            p.setTermFrom(president.getTermFrom());
//        }
//        if (president.getTermTo() != null) {
//            p.setTermTo(president.getTermTo());
//        }
//        if (president.getPoliticalParty() != null) {
//            p.setPoliticalParty(president.getPoliticalParty());
//        }
//        return "Updated";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteByIndex(@PathVariable int id) {
//        PresidentsDB.presidentRepository.remove(id);
//        return "Removed!";
//    }


}
