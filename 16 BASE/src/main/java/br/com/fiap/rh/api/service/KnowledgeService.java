package br.com.fiap.rh.api.service;

import br.com.fiap.rh.api.dto.KnowledgeDTO;
import br.com.fiap.rh.api.model.Mapper;
import br.com.fiap.rh.api.repository.KnowledgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KnowledgeService {

    private KnowledgeRepository knlowedgeRepository;

    public List<KnowledgeDTO> gelAllKnowledge() {
        return knlowedgeRepository.findAll()
                .stream()
                .map(Mapper::toKnowledgeDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
