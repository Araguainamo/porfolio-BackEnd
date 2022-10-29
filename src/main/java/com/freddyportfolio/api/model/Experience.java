package com.freddyportfolio.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Experience {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(nullable = false)
    public String title;

    @Basic
    @Column(nullable = false)
    public String description;
}
