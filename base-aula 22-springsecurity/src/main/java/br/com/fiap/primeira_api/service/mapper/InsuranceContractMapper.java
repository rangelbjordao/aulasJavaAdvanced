package br.com.fiap.primeira_api.service.mapper;

import br.com.fiap.primeira_api.dto.InsuranceContractDTO;
import br.com.fiap.primeira_api.model.InsuranceContract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClaimMapper.class)
public interface InsuranceContractMapper {

    InsuranceContractDTO toDTO(InsuranceContract contract);

    InsuranceContract toEntity(InsuranceContractDTO insuranceContractDTO);

}
