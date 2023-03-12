package co.com.meli.services.implementation;

import co.com.meli.services.IMutantesService;
import co.com.meli.services.IValidacionBaseService;
import co.com.meli.services.IValidacionDatosService;
import co.com.meli.utilities.exceptions.BussinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MutanteService implements IMutantesService {

  private final IValidacionDatosService validacionDatosService;
  private final IValidacionBaseService validacionBaseService;

  /**
   * Metodo que define si el adn ingresado es de un mutante
   *
   * @param dna dna de la persona a validar
   * @return true si es mutante false si no es asi
   */
  @Override
  public boolean isMutant(String[] dna) throws BussinessException {
    return validacionDatosService.validarCoincidencias(
        validacionBaseService.validarBasesNitrogenadas(dna));
  }
}
