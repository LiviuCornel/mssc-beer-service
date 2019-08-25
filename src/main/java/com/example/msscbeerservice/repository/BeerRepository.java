package com.example.msscbeerservice.repository;

import com.example.msscbeerservice.persistence.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
