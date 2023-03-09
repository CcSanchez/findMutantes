package co.com.meli.services.implementation;

import co.com.meli.services.IValidarVerticalService;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class ValidarVerticalService implements IValidarVerticalService {

  /**
   * Metodo que valida si contiene una secuencias de manera vertical
   *
   * @param adn cadena de adn
   * @param row iterador
   * @param column iterador
   * @return cantidad de secuencias encontradas
   */
  public int validar(String[][] adn, int row, int column) {
    var contVertical = new AtomicInteger();
    if (adn.length - row < 4) return contVertical.get();

    if (adn[row][column].equals(adn[row + 1][column])
        && adn[row][column].equals(adn[row + 2][column])
        && adn[row][column].equals(adn[row + 3][column])) contVertical.getAndIncrement();

    return contVertical.get();
  }
}
