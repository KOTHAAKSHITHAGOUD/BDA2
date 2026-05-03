package com.akshitha.cricketmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cricketers")
public class Cricketer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String role;

    @Min(0)
    @Column(nullable = false)
    private int runs;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public Cricketer() {}
    public Cricketer(String name, String role, int runs, Team team) {
        this.name = name;
        this.role = role;
        this.runs = runs;
        this.team = team;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public int getRuns() { return runs; }
    public void setRuns(int runs) { this.runs = runs; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}