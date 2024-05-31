package com.github.llres.springl.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "table1")
public class Pojo1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
