package com.epam.task3.controller;

import com.epam.task3.domain.Estate;
import com.epam.task3.domain.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    EstateRepository estateRepository;

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        Estate estate = new Estate();
        estate.setStreet("StreetTEst");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estate", estate);
        modelAndView.setViewName("admin");
        return modelAndView;
//        Estate estate = new Estate();
//        estate.setStreet("StreetTEst");
//        model.put("estate", estate);
//        return "admin";
    }

    @PostMapping(value = "/admin")
    public void addEstate(HttpServletRequest request, HttpServletResponse response) {
        if(request != null) {
            String street = request.getParameter("street");
            String rooms = request.getParameter("rooms");
            String floors = request.getParameter("floors");
            Estate estate = new Estate();
            estate.setStreet(street);
            estate.setRooms(Integer.valueOf(rooms));
            estate.setFloors(Integer.valueOf(floors));
            estateRepository.save(estate);
        }
    }
}
