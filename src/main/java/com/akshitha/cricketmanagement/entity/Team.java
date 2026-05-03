package com.akshitha.cricketmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String coach;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Cricketer> cricketers = new ArrayList<>();

    public Team() {}
    public Team(String name, String coach) {
        this.name = name;
        this.coach = coach;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }
    public List<Cricketer> getCricketers() { return cricketers; }
    public void setCricketers(List<Cricketer> cricketers) { this.cricketers = cricketers; }
}
