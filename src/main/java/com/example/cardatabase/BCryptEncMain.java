package com.example.cardatabase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncMain {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("user"));
    }
}
