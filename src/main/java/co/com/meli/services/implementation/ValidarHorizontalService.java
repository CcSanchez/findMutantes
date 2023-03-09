package co.com.meli.services.implementation;

import co.com.meli.services.IValidarHorizontalService;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class ValidarHorizontalService implements IValidarHorizontalService {

  /**
   * Metodo que valida si contiene una secuencias de manera horizontal
   *
   * @param adn cadena de adn
   * @param row iterador
   * @param column iterador
   * @return cantidad de secuencias encontradas
   */
  public int validar(String[][] adn, int row, int column) {
    var conHorizontal = new AtomicInteger();

    if (adn.length - column < 4) return conHorizontal.get();

    if (adn[row][column].equals(adn[row][column + 1])
        && adn[row][column].equals(adn[row][column + 2])
        && adn[row][column].equals(adn[row][column + 3])) conHorizontal.getAndIncrement();

    return conHorizontal.get();
  }
}
