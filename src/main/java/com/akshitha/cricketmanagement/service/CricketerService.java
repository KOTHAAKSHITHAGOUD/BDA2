package com.akshitha.cricketmanagement.service;

import com.akshitha.cricketmanagement.entity.Cricketer;
import com.akshitha.cricketmanagement.entity.Team;
import com.akshitha.cricketmanagement.repository.CricketerRepository;
import com.akshitha.cricketmanagement.repository.TeamRepository;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CricketerService {
    private final CricketerRepository cricketerRepository;
    private final TeamRepository teamRepository;

    public CricketerService(CricketerRepository cricketerRepository, TeamRepository teamRepository) {
        this.cricketerRepository = cricketerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Cricketer> getAllCricketers() {
        return cricketerRepository.findAll();
    }

    public Cricketer getCricketerById(Long id) {
        return cricketerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cricketer not found"));
    }

    public Cricketer saveCricketer(Cricketer cricketer, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        cricketer.setTeam(team);
        try {
            return cricketerRepository.save(cricketer);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Unable to save cricketer due to integrity violation", ex);
        }
    }

    public Cricketer updateCricketer(Long id, Cricketer updatedCricketer, Long teamId) {
        Cricketer existing = getCricketerById(id);
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
        existing.setName(updatedCricketer.getName());
        existing.setRole(updatedCricketer.getRole());
        existing.setRuns(updatedCricketer.getRuns());
        existing.setTeam(team);
        return cricketerRepository.save(existing);
    }

    public List<Object[]> getCricketerTeamJoinData() {
        return cricketerRepository.fetchCricketerTeamDetails();
    }
}