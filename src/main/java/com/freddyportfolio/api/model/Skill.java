package com.freddyportfolio.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Basic
    @Column(nullable = false)
    public String name;

    @Getter
    @Setter
    @Basic
    @Column(nullable = false)
    public Integer level;
}
