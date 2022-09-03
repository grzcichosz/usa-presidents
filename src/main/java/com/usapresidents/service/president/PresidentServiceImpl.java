package com.usapresidents.service.president;

import com.usapresidents.exception.exceptions.EntityNotFoundException;
import com.usapresidents.exception.messages.PresidentsControllerExceptionMessages;
import com.usapresidents.model.dto.PresidentDto;
import com.usapresidents.model.entity.President;
import com.usapresidents.model.mapper.PresidentMapper;
import com.usapresidents.repository.PresidentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor
public class PresidentServiceImpl implements PresidentService {

    private final PresidentsRepository presidentsRepository;

    @Override
    public List<PresidentDto> getAllPresidents() {
        return presidentsRepository.findAll().stream()
                .map(PresidentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Set<PresidentDto> findPresidentsByName(String name) {
        Set<President> presidents = presidentsRepository.findPresidentsByName(name);
        if(presidents.isEmpty()){
            throw new EntityNotFoundException(PresidentsControllerExceptionMessages
                    .ENTITY_FOR_PROVIDED_NAME_NOT_EXISTS.getMessage());
        }
        return presidents.stream()
                .map(PresidentMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public Set<PresidentDto> findPresidentsByPoliticalParty(String party) {
        return presidentsRepository.findPresidentsByPoliticalParty(party).stream()
                .map(PresidentMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public PresidentDto savePresident(PresidentDto presidentDto) {
        return PresidentMapper.toDto(presidentsRepository.save(PresidentMapper.toEntity(presidentDto)));
    }

    @Override
    public PresidentDto updatePresident(PresidentDto presidentDto) {
        return presidentsRepository.findById(presidentDto.getId()).map(president -> {
            president.setName(presidentDto.getName());
            president.setSurname(presidentDto.getSurname());
            president.setPoliticalParty(presidentDto.getPoliticalParty());
            president.setTermFrom(presidentDto.getTermFrom());
            president.setTermTo(presidentDto.getTermTo());
            return PresidentMapper.toDto(president);
        }).get();

    }

    @Override
    public PresidentDto updatePresidentPartial(PresidentDto presidentDto) {
        return presidentsRepository.findById(presidentDto.getId()).map(president -> {
            if (nonNull(presidentDto.getName())) {
                president.setName(presidentDto.getName());
            }
            if (nonNull(presidentDto.getSurname())) {
                president.setSurname(presidentDto.getSurname());
            }
            if (nonNull(presidentDto.getTermFrom())) {
                president.setTermFrom(presidentDto.getTermFrom());
            }
            if (nonNull(presidentDto.getTermTo())) {
                president.setTermTo(presidentDto.getTermTo());
            }
            if (nonNull(presidentDto.getPoliticalParty())) {
                president.setPoliticalParty(presidentDto.getPoliticalParty());
            }
            return PresidentMapper.toDto(president);
        }).orElseThrow(()-> new EntityNotFoundException(PresidentsControllerExceptionMessages
                .ENTITY_FOR_PROVIDED_ID_NOT_EXISTS.getMessage()));
    }

    @Override
    public void deletePresident(Long id) {
        presidentsRepository.deleteById(id);
    }
}
