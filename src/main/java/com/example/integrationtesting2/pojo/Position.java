package com.example.integrationtesting2.pojo;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}