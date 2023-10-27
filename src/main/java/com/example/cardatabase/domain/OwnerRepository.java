package com.example.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByFirstName(String firstname);
}
