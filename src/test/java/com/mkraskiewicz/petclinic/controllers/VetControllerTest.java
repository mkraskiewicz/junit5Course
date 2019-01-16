package com.mkraskiewicz.petclinic.controllers;

import com.mkraskiewicz.petclinic.ControllerTests;
import com.mkraskiewicz.petclinic.fauxspring.Model;
import com.mkraskiewicz.petclinic.fauxspring.ModelMapImpl;
import com.mkraskiewicz.petclinic.model.Vet;
import com.mkraskiewicz.petclinic.services.SpecialtyService;
import com.mkraskiewicz.petclinic.services.VetService;
import com.mkraskiewicz.petclinic.services.map.SpecialityMapService;
import com.mkraskiewicz.petclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {

        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController((vetService));
        Vet vet1 = new Vet(1l, "Paul", "Someone", null);
        Vet vet2 = new Vet(2l, "Edward", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);

    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);
        Set modelAttribute = (Set) ((ModelMapImpl)model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}