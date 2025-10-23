package br.com.fiap.primeira_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceContractDTO {
    private long id;
    private String insuranceObject;
    private ZonedDateTime signTimeStamp;
    private ZonedDateTime endCoverageTimeStamp;
    private List<CoverageDTO> coverageList;
    private List<ClaimDTO> claimList;

}
