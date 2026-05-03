package com.akshitha.cricketmanagement.repository;

import com.akshitha.cricketmanagement.entity.Cricketer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CricketerRepository extends JpaRepository<Cricketer, Long> {

    @Query("SELECT c.name, c.role, c.runs, t.name FROM Cricketer c INNER JOIN c.team t")
    List<Object[]> fetchCricketerTeamDetails();
}