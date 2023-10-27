package com.example.cardatabase.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void saveOwner() {
        ownerRepository.save(new Owner("Lucy", "Smith"));
        assertThat(ownerRepository.findByFirstName("Lucy").isPresent()).isTrue();
    }

}