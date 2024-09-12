package com.aleksandr.blogca2023.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Data

    public class Parking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String model;
        @Column
        private String plate;
        @Column
        private String paid;
        @Column
        private String space;
        @Column
        private String datefrom;
        @Column
        private String dateto;


        @OneToMany(mappedBy = "parking", orphanRemoval = true)
        private List<Comment> comments = new ArrayList<>();



    }
