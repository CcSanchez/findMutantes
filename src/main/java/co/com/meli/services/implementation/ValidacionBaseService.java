package co.com.meli.services.implementation;

import co.com.meli.services.IUtilitiesService;
import co.com.meli.services.IValidacionBaseService;
import co.com.meli.utilities.exceptions.BussinessException;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidacionBaseService implements IValidacionBaseService {

  private static final Map<String, Integer> combinaciones = new HashMap<>();

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
}
