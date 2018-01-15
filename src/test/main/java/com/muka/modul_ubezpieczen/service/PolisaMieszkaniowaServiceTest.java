package com.muka.modul_ubezpieczen.service;

import com.muka.modul_ubezpieczen.domain.Ubezpieczenie.PolisaMieszkaniowa;
import com.muka.modul_ubezpieczen.repository.PolisaMieszkaniowaRepository;
import com.muka.modul_ubezpieczen.repository.UbezpieczenieRuchomosciDomowychRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Magda on 13.01.2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class PolisaMieszkaniowaServiceTest {


    @InjectMocks
    PolisaMieszkaniowaService polisaMieszkaniowaService;

    @Mock
    PolisaMieszkaniowaRepository polisaMieszkaniowaRepository;

    @Mock
    UbezpieczenieRuchomosciDomowychRepository ubezpieczenieRuchomosciDomowychRepository;

    @Test
    public void shouldReturnPolisaMieszkaniowa() {
        PolisaMieszkaniowa polisaMieszkaniowa = PolisaMieszkaniowa.builder()
            .miasto("Krakow")
            .numerMieszkania(1)
            .build();

        when(polisaMieszkaniowaRepository.save(polisaMieszkaniowa)).thenReturn(polisaMieszkaniowa);

        PolisaMieszkaniowa dodanaPolisa = polisaMieszkaniowaService.dodajPoliseMieszkaniowa(polisaMieszkaniowa);

        assertEquals(polisaMieszkaniowa.getNumerMieszkania(), dodanaPolisa.getNumerMieszkania());
    }


}
