package br.com.fiap.rh.api.repository;

import br.com.fiap.rh.api.model.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
}
