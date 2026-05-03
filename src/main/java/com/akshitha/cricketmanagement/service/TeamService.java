package com.akshitha.cricketmanagement.service;

import com.akshitha.cricketmanagement.entity.Team;
import com.akshitha.cricketmanagement.repository.TeamRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
    }
}