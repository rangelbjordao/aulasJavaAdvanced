package br.com.fiap.primeira_api.controller;

import br.com.fiap.primeira_api.dto.InsuranceContractDTO;
import br.com.fiap.primeira_api.service.InsuranceContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Controller Class
@RestController
@RequestMapping("/api/insurance-contracts")
@RequiredArgsConstructor
public class InsuranceContractController {

    private final InsuranceContractService insuranceContractService;

    // Create a new insurance contract
    @PostMapping
    public ResponseEntity<InsuranceContractDTO> createInsuranceContract(@RequestBody InsuranceContractDTO contractDTO) {
        InsuranceContractDTO savedContract = insuranceContractService.saveInsuranceContract(contractDTO);
        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
    }

    // Get an insurance contract by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceContractDTO> getInsuranceContractById(@PathVariable long id) {
        Optional<InsuranceContractDTO> contractDTO = insuranceContractService.getInsuranceContractById(id);
        return contractDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get all insurance contracts
    @GetMapping
    public ResponseEntity<List<InsuranceContractDTO>> getAllInsuranceContracts() {
        List<InsuranceContractDTO> contracts = insuranceContractService.getAllInsuranceContracts();
        return ResponseEntity.ok(contracts);
    }

    // Get expired insurance contracts
    @GetMapping("/expired")
    public ResponseEntity<List<InsuranceContractDTO>> getExpiredContracts() {
        List<InsuranceContractDTO> expiredContracts = insuranceContractService.getExpiredContracts();
        return ResponseEntity.ok(expiredContracts);
    }

    // Delete an insurance contract by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsuranceContractById(@PathVariable long id) {
        insuranceContractService.deleteInsuranceContractById(id);
        return ResponseEntity.noContent().build();
    }
}