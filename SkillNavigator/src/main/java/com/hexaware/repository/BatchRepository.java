package com.hexaware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Long>{

}