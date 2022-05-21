package com.chitresh.laa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chitresh.laa.entities.LegalExpert;

public interface LegalExpertRepository extends JpaRepository<LegalExpert, Long>{
	Optional<LegalExpert> findById(Long id);
}
