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
class ValidacionBaseServiceTest {

  @InjectMocks ValidacionBaseService validacionBaseService;

  @Mock UtilitiesService utilitiesService;

  @ParameterizedTest
  @DisplayName("Validar exitoso")
  @MethodSource("setData")
  void validarBasesNitrogenadasValido(String[] dna) {
    String[][] base = validacionBaseService.validarBasesNitrogenadas(dna);
    assertNotNull(base);
  }

  @ParameterizedTest
  @MethodSource("setDataError")
  void validarBasesNitrogenadasInvalido(String[] dna) {
    Mockito.doThrow(BussinessException.class).when(utilitiesService).validarBase("ATGCGCGA");
    assertThrows(Exception.class, () -> validacionBaseService.validarBasesNitrogenadas(dna));
  }

  private static Stream<Arguments> setData() {
    String[] dna = {
      "ATGCGCGA", "CAGTG", "TCATGCGT", "ACGG", "CCCCCCCC", "TCACTCGG", "TCACTCGG", "TCACTCGG"
    };
    return Stream.of(Arguments.of((Object) dna));
  }

  private static Stream<Arguments> setDataError() {
    String[] dna = {
      "ATGCGCXX", "CAGTGCGC", "TCATGCGT", "AGCAGCGG", "CCCCCCCC", "TCACTCGG", "TCACTCGG", "TCACTCGG"
    };
    return Stream.of(Arguments.of((Object) dna));
  }
}
