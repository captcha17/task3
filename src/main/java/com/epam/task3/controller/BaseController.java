package com.epam.task3.controller;

import com.epam.task3.domain.Agent;
import com.epam.task3.domain.AgentRepository;
import com.epam.task3.domain.Estate;
import com.epam.task3.domain.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.Month;
import java.util.Date;
import java.util.Optional;

@Controller
public class BaseController {

    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private AgentRepository agentRepository;
    
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estates",  estateRepository.findAll());
        modelAndView.addObject("agents",  agentRepository.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView form(Estate estate, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (estate != null) {
            estate.setStartDate(new Date());
            estate.setStatus(Estate.Status.SALE);
            Agent persistedAgent = agentRepository.findByName(estate.getAgent().getName());
            estate.setAgent(persistedAgent);
            estateRepository.save(estate);
        }
        modelAndView.addObject("estates",  estateRepository.findAll());
        modelAndView.addObject("agents",  agentRepository.findAll());
        modelAndView.setViewName("redirect:");
        return modelAndView;
    }

    @PostMapping("/countUp")
    public @ResponseBody int countUp(long id) {
        Optional<Estate> byId = estateRepository.findById(id);
        Estate estate = byId.get();
        int views = estate.getViews();
        estate.setViews(++views);
        estateRepository.save(estate);
        return views;
    }

    @GetMapping("/buy/{estateID}")
    public String buy(@PathVariable long estateID) {
        Optional<Estate> byId = estateRepository.findById(estateID);
        Estate estate = byId.get();
        estate.setSoldMonth(Month.of(new Date().getMonth()));
        estate.setStatus(Estate.Status.SOLD);
        estateRepository.save(estate);
        return "/";
    }
}
