package com.freddyportfolio.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
public class UserPorfolio {
    @Transient
    final String FOREIGN_COLUMN_NAME = "user_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(nullable = false)
    private String username;

    @Basic
    @Column(nullable = false)
    private String password;


    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String lastname;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Basic
    private String title;

    @Basic
    private char genre;

    @Basic
    private String description;

    @Basic
    @Column(nullable = false)
    private String email;

    @Basic
    private String telephone;

    @Basic
    private String address;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = FOREIGN_COLUMN_NAME)
    private List<Skill> skills;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = FOREIGN_COLUMN_NAME)
    private List<Project> projects;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = FOREIGN_COLUMN_NAME)
    private List<Experience> experiences;
}
