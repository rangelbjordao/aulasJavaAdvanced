package br.com.fiap.projetos_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContractDTO {
    private long id;
    private String insuranceObject;
    private ZonedDateTime signTimeStamp;
    private ZonedDateTime endCoverageTimeStamp;
}
