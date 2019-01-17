package com.mkraskiewicz.petclinic.services.springdatajpa;

import com.mkraskiewicz.petclinic.model.Visit;
import com.mkraskiewicz.petclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        //given
        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        //when
        Set<Visit> foundVisits = service.findAll();

        //then
        verify(visitRepository).findAll();
        assertEquals(foundVisits.size(), 1);
    }

    @Test
    void findById() {

        //given
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        //when
        Visit foundVisit = service.findById(anyLong());
        //then
        verify(visitRepository).findById(anyLong());
        assertNotNull(foundVisit);
    }

    @Test
    void save() {

        //given
        Visit visit = new Visit();
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);
        //when
        Visit savedVisit = service.save(new Visit());
        //then
        verify(visitRepository).save(any(Visit.class));
        assertNotNull(savedVisit);
    }

    @Test
    void delete() {

        //given
        Visit visit = new Visit();
        //when
        service.delete(visit);
        //then
        verify(visitRepository).delete(any(Visit.class));

    }

    @Test
    void deleteById() {

        //when
        service.deleteById(anyLong());
        //then
        verify(visitRepository).deleteById(anyLong());
    }
}