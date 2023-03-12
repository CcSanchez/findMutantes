package co.com.meli.controllers;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.dto.MutantInDto;
import co.com.meli.services.implementation.MutanteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class MutanteControllerTest {

  @InjectMocks MutanteController mutanteController;

  @Mock MutanteService mutanteService;

  @Test
  void getMutant() {
    Mockito.when(mutanteService.isMutant(new String[] {"", ""})).thenReturn(true);
    assertNotNull(mutanteController.getMutant(new MutantInDto()));
  }

  @Test
  void getHuman() {
    Mockito.when(mutanteService.isMutant(new String[] {"", ""})).thenReturn(false);
    assertEquals(
        HttpStatus.FORBIDDEN, mutanteController.getMutant(new MutantInDto()).getStatusCode());
  }
}
