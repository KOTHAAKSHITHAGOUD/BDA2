package com.akshitha.cricketmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshitha.cricketmanagement.entity.Cricketer;
import com.akshitha.cricketmanagement.service.CricketerService;
import com.akshitha.cricketmanagement.service.TeamService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cricketers")
public class CricketerController {

    private final CricketerService cricketerService;
    private final TeamService teamService;

    public CricketerController(CricketerService cricketerService, TeamService teamService) {
        this.cricketerService = cricketerService;
        this.teamService = teamService;
    }

    @GetMapping
    public String listCricketers(Model model) {
        model.addAttribute("cricketers", cricketerService.getAllCricketers());
        model.addAttribute("joinedData", cricketerService.getCricketerTeamJoinData());
        return "cricketer-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("cricketer", new Cricketer());
        model.addAttribute("teams", teamService.getAllTeams());
        return "cricketer-form";
    }

    @PostMapping("/save")
    public String saveCricketer(@Valid @ModelAttribute("cricketer") Cricketer cricketer,
                                BindingResult result,
                                @RequestParam("teamId") Long teamId,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("teams", teamService.getAllTeams());
            return "cricketer-form";
        }

        try {
            cricketerService.saveCricketer(cricketer, teamId);
            return "redirect:/cricketers";
        } catch (Exception e) {
            model.addAttribute("teams", teamService.getAllTeams());
            model.addAttribute("errorMessage", "Could not save cricketer: " + e.getMessage());
            return "cricketer-form";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("cricketer", cricketerService.getCricketerById(id));
        model.addAttribute("teams", teamService.getAllTeams());
        return "cricketer-edit";
    }

    @PostMapping("/update/{id}")
    public String updateCricketer(@PathVariable Long id,
                                  @Valid @ModelAttribute("cricketer") Cricketer cricketer,
                                  BindingResult result,
                                  @RequestParam("teamId") Long teamId,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("teams", teamService.getAllTeams());
            return "cricketer-edit";
        }

        cricketerService.updateCricketer(id, cricketer, teamId);
        return "redirect:/cricketers";
    }
}