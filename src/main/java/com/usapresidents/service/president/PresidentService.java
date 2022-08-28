package com.usapresidents.service.president;

import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.entity.President;

import java.util.List;

public interface PresidentService {
    List<PresidentDto> getAllPresidents();

    PresidentDto savePresident(PresidentDto presidentDto);

    PresidentDto updatePresident(PresidentDto presidentDto);
}
