package co.com.meli.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.dto.StatsOutDto;
import co.com.meli.dto.StatsOutInterface;
import co.com.meli.jpa.repositories.AuditoriaMutanteRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StatsServiceTest {

  @Mock AuditoriaMutanteRepository repository;

  @Spy StatsOutInterface statsOutInterface;

  @InjectMocks StatsService statsService;

  @Test
  @DisplayName("Obtener estadisticas")
  void getStats() {
    Mockito.when(repository.findStats()).thenReturn(Optional.of(statsOutInterface));
    StatsOutDto statsOutDto = statsService.getStats();
    assertNotNull(statsOutDto);
  }
}
