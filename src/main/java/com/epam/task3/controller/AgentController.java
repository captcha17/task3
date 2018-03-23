package com.epam.task3.controller;

import com.epam.task3.domain.AgentRepository;
import com.epam.task3.domain.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgentController {
    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/agents")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("agents",  agentRepository.getAllAgentsWithTotalSum());
        modelAndView.setViewName("agents");
        return modelAndView;
    }
}
