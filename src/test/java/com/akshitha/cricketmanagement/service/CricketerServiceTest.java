package com.akshitha.cricketmanagement.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.akshitha.cricketmanagement.entity.Cricketer;
import com.akshitha.cricketmanagement.entity.Team;
import com.akshitha.cricketmanagement.repository.CricketerRepository;
import com.akshitha.cricketmanagement.repository.TeamRepository;

@ExtendWith(MockitoExtension.class)
class CricketerServiceTest {

    @Mock
    private CricketerRepository cricketerRepository;

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private CricketerService cricketerService;

    @Test
    void shouldSaveCricketer() {
        Team team = new Team("RCB", "Andy Flower");
        team.setId(1L);

        Cricketer cricketer = new Cricketer("Virat Kohli", "Batsman", 8004, team);

        when(teamRepository.findById(1L)).thenReturn(Optional.of(team));
        when(cricketerRepository.save(any(Cricketer.class))).thenReturn(cricketer);

        Cricketer saved = cricketerService.saveCricketer(cricketer, 1L);

        assertEquals("Virat Kohli", saved.getName());
    }
}