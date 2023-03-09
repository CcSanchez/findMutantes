package co.com.meli.services;

import co.com.meli.utilities.exceptions.BussinessException;

public interface IMutantesService {

  /**
   * Metodo que define si el adn ingresado es de un mutante
   *
   * @param adn adn de la persona a validar
   * @return true si es mutante false si no es asi
   */
  public boolean isMutant(String[] adn) throws BussinessException;
}
