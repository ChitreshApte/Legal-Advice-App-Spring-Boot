package com.chitresh.laa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitresh.laa.entities.QueryEntity;

@Repository
public interface QueryRepository extends JpaRepository<QueryEntity, Long>{

}
