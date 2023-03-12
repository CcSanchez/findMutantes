package co.com.meli.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.jpa.entities.AuditoriaMutanteEntity;
import co.com.meli.jpa.repositories.AuditoriaMutanteRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuditoriaServiceTest {

  @Mock AuditoriaMutanteRepository repository;

  @InjectMocks @Spy AuditoriaService auditoriaService;

  @DisplayName("Adn no encontrado")
  @ParameterizedTest
  @MethodSource("setData")
  void obtenerRegistroNoEncontrado(String dna) {
    Mockito.when(repository.findByDna(dna)).thenReturn(Optional.of(List.of()));
    assertTrue(auditoriaService.obtenerRegistro(dna));
  }

  @DisplayName("Adn encontrado")
  @ParameterizedTest
  @MethodSource("setData")
  void obtenerRegistroEncontrado(String dna) {
    Mockito.when(repository.findByDna(dna))
        .thenReturn(
            Optional.of(
                List.of(
                    AuditoriaMutanteEntity.builder()
                        .id(UUID.randomUUID().toString())
                        .dna(dna)
                        .date(new Date())
                        .ismutant(1)
                        .combinaciones("{AAAA:1}")
                        .build())));
    assertFalse(auditoriaService.obtenerRegistro(dna));
  }

  private static Stream<String> setData() {
    return Stream.of(
        "[[A, T, G, C, G, A],"
            + " [C, T, G, T, G, C],"
            + " [T, T, A, T, A, T],"
            + " [A, G, A, A, G, G],"
            + " [C, C, G, C, T, A],"
            + " [T, C, A, C, T, G]]");
  }
}
