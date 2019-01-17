package com.mkraskiewicz.petclinic.services.springdatajpa;


import com.mkraskiewicz.petclinic.model.Speciality;
import com.mkraskiewicz.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void testDeleteByObject() {

        Speciality speciality = new Speciality();
        service.delete(speciality);

        verify(specialtyRepository).delete(any(Speciality.class));

    }

    @Test
    void testFindById() {

        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
        Speciality foundSpecialty = service.findById(1l);

        assertNotNull(foundSpecialty);
        verify(specialtyRepository, times(1)).findById(anyLong());

    }


    @Test
    void testDeleteById() {

        service.deleteById(1l);
        verify(specialtyRepository, times(1)).deleteById(1l);
    }

    @Test
    void testDeleteAtLeast() {

        service.deleteById(1l);
        service.deleteById(1l);
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
    }

    @Test
    void testDeleteAtMost() {

        service.deleteById(1l);
        service.deleteById(1l);
        verify(specialtyRepository, atMost(5)).deleteById(1l);
    }

    @Test
    void testDelete(){

        service.delete(new Speciality());
    }
}