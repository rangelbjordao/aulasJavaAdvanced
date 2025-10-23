package br.com.fiap.primeira_api.dto;

import br.com.fiap.primeira_api.model.enums.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDTO {
    private long id;
    private ZonedDateTime claimDate;
    private String claimText;
    private ClaimStatus status;

}
