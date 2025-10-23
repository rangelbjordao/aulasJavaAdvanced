package br.com.fiap.primeira_api.service.mapper;

import br.com.fiap.primeira_api.dto.ClaimDTO;
import br.com.fiap.primeira_api.model.Claim;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    ClaimDTO toDTO(Claim claim);

    @Mapping(target = "insuranceContract", ignore = true)
    Claim toEntity(ClaimDTO claimDTO);

}
