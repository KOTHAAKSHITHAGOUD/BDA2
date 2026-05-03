package com.akshitha.cricketmanagement.config;

import com.akshitha.cricketmanagement.entity.Cricketer;
import com.akshitha.cricketmanagement.entity.Team;
import com.akshitha.cricketmanagement.repository.CricketerRepository;
import com.akshitha.cricketmanagement.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(TeamRepository teamRepository, CricketerRepository cricketerRepository) {
        return args -> {
            if (teamRepository.count() == 0) {
                Team rcb = teamRepository.save(new Team("RCB", "Andy Flower"));
                Team mi = teamRepository.save(new Team("MI", "Mark Boucher"));
                Team csk = teamRepository.save(new Team("CSK", "Stephen Fleming"));
                Team kkr = teamRepository.save(new Team("KKR", "Chandrakant Pandit"));
                Team rr = teamRepository.save(new Team("RR", "Kumar Sangakkara"));
                Team srh = teamRepository.save(new Team("SRH", "Daniel Vettori"));
                Team dc = teamRepository.save(new Team("DC", "Ricky Ponting"));
                Team gt = teamRepository.save(new Team("GT", "Ashish Nehra"));
                Team pbks = teamRepository.save(new Team("PBKS", "Trevor Bayliss"));
                Team lsg = teamRepository.save(new Team("LSG", "Justin Langer"));

                cricketerRepository.save(new Cricketer("Virat Kohli", "Batsman", 8004, rcb));
                cricketerRepository.save(new Cricketer("Faf du Plessis", "Batsman", 4571, rcb));
                cricketerRepository.save(new Cricketer("Rohit Sharma", "Batsman", 6628, mi));
                cricketerRepository.save(new Cricketer("Jasprit Bumrah", "Bowler", 120, mi));
                cricketerRepository.save(new Cricketer("MS Dhoni", "Wicketkeeper", 5082, csk));
                cricketerRepository.save(new Cricketer("Ravindra Jadeja", "All-rounder", 2806, csk));
                cricketerRepository.save(new Cricketer("Shreyas Iyer", "Batsman", 3127, kkr));
                cricketerRepository.save(new Cricketer("Sanju Samson", "Wicketkeeper", 4419, rr));
                cricketerRepository.save(new Cricketer("Pat Cummins", "Bowler", 515, srh));
                cricketerRepository.save(new Cricketer("Rishabh Pant", "Wicketkeeper", 3284, lsg));
            }
        };
    }
}