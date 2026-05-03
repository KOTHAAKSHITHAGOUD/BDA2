package com.akshitha.cricketmanagement.repository;

import com.akshitha.cricketmanagement.entity.Cricketer;
import com.akshitha.cricketmanagement.entity.Team;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class CricketerRepositoryTest {

    @Autowired
    private CricketerRepository cricketerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void shouldReturnInnerJoinData() {
        Team team = teamRepository.save(new Team("RCB", "Andy Flower"));
        cricketerRepository.save(new Cricketer("Virat Kohli", "Batsman", 8004, team));

        List<Object[]> result = cricketerRepository.fetchCricketerTeamDetails();

        assertFalse(result.isEmpty());
    }
}