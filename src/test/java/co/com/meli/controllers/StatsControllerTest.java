package co.com.meli.controllers;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.dto.StatsOutDto;
import co.com.meli.services.implementation.StatsService;
import co.com.meli.utilities.exceptions.BussinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StatsControllerTest {

  @InjectMocks StatsController statsController;

  @Mock StatsService statsService;

  @Test
  @DisplayName("Stast Controller")
  void getStats() {
    Mockito.when(statsService.getStats()).thenReturn(new StatsOutDto());
    assertNotNull(statsController.getStats());
  }

  @Test
  @DisplayName("Stast Controller")
  void getStatsError() {
    Mockito.when(statsService.getStats()).thenThrow(new BussinessException(""));
    assertThrows(BussinessException.class, () -> statsController.getStats());
  }
}
