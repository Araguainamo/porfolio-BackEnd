package com.freddyportfolio.api.model;

import lombok.Setter;
import lombok.Getter;


import javax.persistence.*;

@Entity

public class Project {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Basic
    @Column(nullable = false)
    public String title;

    @Getter
    @Setter
    @Basic
    @Column(nullable = false)
    public String description;



}
