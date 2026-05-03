package com.akshitha.cricketmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akshitha.cricketmanagement.entity.Team;
import com.akshitha.cricketmanagement.service.TeamService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String listTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "team-list";
    }

    @GetMapping("/new")
    public String showTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "team-form";
    }

    @PostMapping("/save")
    public String saveTeam(@Valid @ModelAttribute("team") Team team,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "team-form";
        }

        try {
            teamService.saveTeam(team);
            return "redirect:/teams";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Could not save team: " + e.getMessage());
            return "team-form";
        }
    }
}