package com.akshitha.cricketmanagement.repository;

import com.akshitha.cricketmanagement.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}