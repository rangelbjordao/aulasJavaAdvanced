package br.com.fiap.rh.api.controller;

import br.com.fiap.rh.api.service.KnowledgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/knowledges")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    @GetMapping
    public ResponseEntity<?> getAllKnowledges() {
        return ResponseEntity.ok(knowledgeService.gelAllKnowledge());
    }
}
