package co.com.meli.services;

import co.com.meli.utilities.exceptions.BussinessException;

public interface IValidacionDatosService {

  /**
   * Metodo que valida que los datos ingresados correspondan a los permitidos (A,T,C,G)
   *
   * @param dna cadena de adn suministrada
   * @return true si son validos
   */
  String[][] validarBasesNitrogenadas(String[] dna) throws BussinessException;

  boolean validarCoincidencias(String[][] dna);
}
