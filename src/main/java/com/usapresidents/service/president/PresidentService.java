package com.usapresidents.service.president;

import com.usapresidents.model.entity.President;

import java.util.List;

public interface PresidentService {
    List<President> getAllPresidents();

    President savePresident(President president);
}
