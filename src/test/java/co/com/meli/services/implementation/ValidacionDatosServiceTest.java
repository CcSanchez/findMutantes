package co.com.meli.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValidacionDatosServiceTest {

  @InjectMocks @Spy ValidacionDatosService validacionDatosService;

  @Mock AuditoriaService auditoriaService;

  @Mock UtilitiesService utilitiesService;

  @ParameterizedTest
  @MethodSource("setearInfo")
  void validarCoincidencias(String[][] adn) {
    assertTrue(validacionDatosService.validarCoincidencias(adn));
  }

  private static Stream<Arguments> setearInfo() {
    String[][] dna1 = {
      {"A", "T", "G", "C", "G", "A"},
      {"C", "A", "G", "T", "G", "C"},
      {"T", "T", "A", "C", "G", "T"},
      {"A", "G", "C", "A", "G", "G"},
      {"C", "C", "C", "C", "T", "A"},
      {"C", "C", "A", "C", "T", "G"}
    };

    String[][] dna2 = {
      {"A", "T", "G", "C", "G", "C", "G", "A"},
      {"C", "A", "G", "T", "G", "C", "G", "C"},
      {"T", "C", "A", "T", "G", "C", "G", "T"},
      {"A", "G", "C", "A", "G", "C", "G", "G"},
      {"C", "C", "C", "C", "C", "C", "C", "C"},
      {"T", "C", "A", "C", "T", "C", "G", "G"},
      {"T", "C", "A", "C", "T", "C", "G", "G"},
      {"T", "C", "A", "C", "T", "C", "G", "G"}
    };
    return Stream.of(Arguments.of((Object) dna1), Arguments.of((Object) dna2));
  }
}
