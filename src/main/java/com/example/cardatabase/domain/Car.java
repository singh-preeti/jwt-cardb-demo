package com.example.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String model;
    private String color;
    private String registrationNum;

    private int yr, price;

    @Column(name = "explanation", nullable = false, length = 512)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car(String brand, String model, String color, String registrationNum, int yr, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNum = registrationNum;
        this.yr = yr;
        this.price = price;
        this.description = String.join(" ", brand, model, color, registrationNum, yr + "");
        this.owner = owner;
    }
}
