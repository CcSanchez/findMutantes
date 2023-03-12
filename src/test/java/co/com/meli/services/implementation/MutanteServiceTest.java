package co.com.meli.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.utilities.exceptions.BussinessException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MutanteServiceTest {

  @InjectMocks MutanteService mutanteService;

  @Mock ValidacionDatosService validacionDatosService;
  @Mock ValidacionBaseService validacionBaseService;

  @ParameterizedTest
  @DisplayName("Es mutante")
  @MethodSource("setData")
  void isMutant(String[] dna) {
    String[][] adn = {
      {"A", "T", "G", "C", "G", "A"},
      {"C", "A", "G", "T", "G", "C"},
      {"T", "T", "A", "C", "G", "T"},
      {"A", "G", "C", "A", "G", "G"},
      {"C", "C", "C", "C", "T", "A"},
      {"C", "C", "A", "C", "T", "G"}
    };
    Mockito.when(validacionBaseService.validarBasesNitrogenadas(dna)).thenReturn(adn);
    Mockito.when(validacionDatosService.validarCoincidencias(adn)).thenReturn(true);
    assertTrue(mutanteService.isMutant(dna));
  }

  @ParameterizedTest
  @DisplayName("No es mutante")
  @MethodSource("setData")
  void isNotMutant(String[] dna) {
    String[][] adn = {
      {"A", "T", "G", "C", "G", "A"},
      {"C", "A", "G", "T", "G", "C"},
      {"T", "T", "A", "C", "G", "T"},
      {"A", "G", "C", "A", "G", "G"},
      {"C", "C", "C", "C", "T", "A"},
      {"C", "C", "A", "C", "T", "G"}
    };
    Mockito.when(validacionBaseService.validarBasesNitrogenadas(dna)).thenReturn(adn);
    Mockito.when(validacionDatosService.validarCoincidencias(adn)).thenReturn(false);
    assertFalse(mutanteService.isMutant(dna));
  }

  @ParameterizedTest
  @DisplayName("Exception ")
  @MethodSource("setData")
  void exception(String[] dna) {
    String[][] adn = {
      {"A", "T", "G", "C", "G", "A"},
      {"C", "A", "G", "T", "G", "C"},
      {"T", "T", "A", "C", "G", "T"},
      {"A", "G", "C", "A", "G", "G"},
      {"C", "C", "C", "C", "T", "A"},
      {"C", "C", "A", "C", "T", "G"}
    };
    Mockito.when(validacionBaseService.validarBasesNitrogenadas(dna))
        .thenThrow(new BussinessException(""));
    assertThrows(
        BussinessException.class, () -> validacionBaseService.validarBasesNitrogenadas(dna));
  }

  private static Stream<Arguments> setData() {
    String[] dna = {
      "ATGCGCGA", "CAGTGCGC", "TCATGCGT", "AGCAGCGG", "CCCCCCCC", "TCACTCGG", "TCACTCGG", "TCACTCGG"
    };
    return Stream.of(Arguments.of((Object) dna));
  }
}
