package com.mkraskiewicz.petclinic.controllers;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oupsHandler(){

        throw new ValueNotFoundException();
    }
}
