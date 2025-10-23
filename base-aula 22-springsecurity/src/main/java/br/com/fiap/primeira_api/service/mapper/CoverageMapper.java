package br.com.fiap.primeira_api.service.mapper;

import br.com.fiap.primeira_api.dto.CoverageDTO;
import br.com.fiap.primeira_api.model.Coverage;
import org.mapstruct.Mapping;

public interface CoverageMapper {

    CoverageDTO toDTO(Coverage coverage);

    @Mapping(target = "insuranceContract", ignore = true)
    Coverage toEntity(CoverageDTO coverageDTO);

}
