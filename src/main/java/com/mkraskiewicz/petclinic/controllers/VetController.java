package com.mkraskiewicz.petclinic.controllers;

import com.mkraskiewicz.petclinic.fauxspring.Model;
import com.mkraskiewicz.petclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
