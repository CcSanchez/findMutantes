package co.com.meli.services.implementation;

import co.com.meli.services.*;
import co.com.meli.utilities.exceptions.BussinessException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidacionDatosService implements IValidacionDatosService {

  private final IValidarDiagonalesService validarDiagonales;

  private final IValidarHorizontalService validarHorizontal;

  private final IValidarVerticalService validarVertical;

  private final IUtilitiesService utilities;

  /**
   * Metodo que valida que los datos ingresados correspondan a los permitidos (A,T,C,G)
   *
   * @param dna cadena de dna suministrada
   * @return true si son validos
   */
  @Override
  public String[][] validarBasesNitrogenadas(String[] dna) throws BussinessException {
    return Arrays.stream(dna)
        .map(
            x -> {
              utilities.validarLonguitud(x, dna.length);
              utilities.validarBase(x);
              return x.split("");
            })
        .toArray(value -> new String[value][value]);
  }

  /**
   * Metodo que valida las secuencias en la matriz adn
   *
   * @param adn tabla adn generada con base a los dna ingresados
   * @return true si es mutante false si no lo es
   */
  @Override
  public boolean validarCoincidencias(String[][] adn) {
    var count = new AtomicInteger();
    for (var row = 0; row < adn.length; row++) {
      for (var column = 0; column < adn.length; column++) {
        if (this.utilities.validarMutante(
            count.getAndAdd(validarHorizontal.validar(adn, row, column)))) return true;
        if (this.utilities.validarMutante(
            count.getAndAdd(validarVertical.validar(adn, row, column)))) return true;
        if (this.utilities.validarMutante(
            count.getAndAdd(validarDiagonales.validar(adn, row, column)))) return true;
      }
    }
    return this.utilities.validarMutante(count.get());
  }
}
