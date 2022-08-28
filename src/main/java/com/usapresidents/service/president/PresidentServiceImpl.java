package com.usapresidents.service.president;

import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.mapper.PresidentMapper;
import com.usapresidents.repository.PresidentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PresidentServiceImpl implements PresidentService {

    private final PresidentsRepository presidentsRepository;

    @Override
    public List<PresidentDto> getAllPresidents() {
        return presidentsRepository.findAll().stream()
                .map(PresidentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PresidentDto savePresident(PresidentDto presidentDto) {
        return PresidentMapper.toDto(presidentsRepository.save(PresidentMapper.toEntity(presidentDto)));
    }
    @Override
    public PresidentDto updatePresident(PresidentDto presidentDto){
        presidentsRepository.findById(presidentDto.getId()).ifPresent(president -> {
            president.setName(presidentDto.getName());
            president.setSurname(presidentDto.getSurname());
            president.setPoliticalParty(presidentDto.getPoliticalParty());
            president.setTermFrom(presidentDto.getTermFrom());
            president.setTermTo(presidentDto.getTermTo());
        });
        return PresidentMapper.toDto(presidentsRepository.getReferenceById(presidentDto.getId()));
    }
}
