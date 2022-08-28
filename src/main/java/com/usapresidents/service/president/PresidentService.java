package com.usapresidents.service.president;

import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.entity.President;

import java.util.List;
import java.util.Set;

public interface PresidentService {
    List<PresidentDto> getAllPresidents();

    Set<PresidentDto> findPresidentsByName(String name);

    Set<PresidentDto> findPresidentsByPoliticalParty(String name);

    PresidentDto savePresident(PresidentDto presidentDto);

    PresidentDto updatePresident(PresidentDto presidentDto);

    PresidentDto updatePresidentPartial(PresidentDto presidentDto);

    void deletePresident(Long id);
}
