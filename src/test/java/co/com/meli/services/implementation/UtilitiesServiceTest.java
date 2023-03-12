package co.com.meli.services.implementation;

import static org.junit.jupiter.api.Assertions.*;

import co.com.meli.utilities.exceptions.BussinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UtilitiesServiceTest {

  @InjectMocks UtilitiesService utilitiesService;

  @ParameterizedTest
  @DisplayName("Validar Mutante True")
  @CsvSource({"2", "3", "4"})
  void validarMutanteTrue(int cont) {
    assertTrue(utilitiesService.validarMutante(cont));
  }

  @ParameterizedTest
  @DisplayName("Validar Mutante False")
  @CsvSource({"0", "1"})
  void validarMutanteFalse(int cont) {
    assertFalse(utilitiesService.validarMutante(cont));
  }

  @ParameterizedTest
  @DisplayName("Validar Longuitud Valida")
  @CsvSource({"AAAA,4", "AAAAAA,6"})
  void validarLonguitudValida(String row, Integer size) {
    utilitiesService.validarLonguitud(row, size);
  }

  @ParameterizedTest
  @DisplayName("Validar Longuitud Invalida")
  @CsvSource({"AAAA,2", "AAAAAA,3"})
  void validarLonguitudInvalida(String row, Integer size) {
    assertThrows(BussinessException.class, () -> utilitiesService.validarLonguitud(row, size));
  }

  @ParameterizedTest
  @DisplayName("Validar Base Valida")
  @CsvSource({"ATGCGCGA", "CAGTGCGC", "TCATGCGT"})
  void validarBase(String row) {
    utilitiesService.validarBase(row);
  }

  @ParameterizedTest
  @DisplayName("Validar Base Invalida")
  @CsvSource({"ATGCGCMA", "CXGTGCGC", "TCATGCGL"})
  void validarBaseInvalida(String row) {
    assertThrows(BussinessException.class, () -> utilitiesService.validarBase(row));
  }
}
