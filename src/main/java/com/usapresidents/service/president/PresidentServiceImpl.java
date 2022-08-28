package com.usapresidents.service.president;

import com.usapresidents.model.entity.President;
import com.usapresidents.repository.PresidentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresidentServiceImpl implements PresidentService {

    private final PresidentsRepository presidentsRepository;

    @Override
    public List<President> getAllPresidents() {

        return presidentsRepository.findAll();
    }


    public President savePresident(President president){
        return presidentsRepository.save(president);
    }
}
