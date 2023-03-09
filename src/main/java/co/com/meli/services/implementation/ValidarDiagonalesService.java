package co.com.meli.services.implementation;

import co.com.meli.services.IValidarDiagonalesService;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class ValidarDiagonalesService implements IValidarDiagonalesService {

  /**
   * Metodo que valida si contiene una secuencias de manera diagonal tanto derecha izquierda, como
   * izquierda derecha
   *
   * @param adn cadena de adn
   * @param row iterador
   * @param column iterador
   * @return cantidad de secuencias encontradas
   */
  public int validar(String[][] adn, int row, int column) {
    var contDiagonales = new AtomicInteger();
    if (adn.length - row >= 4 && adn.length - column >= 4) {
      if (adn[row][column].equals(adn[row + 1][column + 1])
          && adn[row][column].equals(adn[row + 2][column + 2])
          && adn[row][column].equals(adn[row + 3][column + 3])) contDiagonales.getAndIncrement();

      var acumulado = adn.length - 1 - column;
      if (adn[row][acumulado].equals(adn[row + 1][acumulado - 1])
          && adn[row][acumulado].equals(adn[row + 2][acumulado - 2])
          && adn[row][acumulado].equals(adn[row + 3][acumulado - 3]))
        contDiagonales.getAndIncrement();
    }
    return contDiagonales.get();
  }
}
