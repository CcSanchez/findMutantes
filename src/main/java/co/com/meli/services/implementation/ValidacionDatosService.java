package co.com.meli.services.implementation;

import co.com.meli.dto.AuditoriaDto;
import co.com.meli.services.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidacionDatosService implements IValidacionDatosService {

  private static final Map<String, Integer> combinaciones = new HashMap<>();

  private final IUtilitiesService utilities;

  private final IAuditoriaService auditoriaService;

  /**
   * Metodo que valida las secuencias en la matriz adn
   *
   * @param dna tabla adn generada con base a los dna ingresados
   * @return true si es mutante false si no lo es
   */
  @Override
  public boolean validarCoincidencias(String[][] dna) {
    var cont = new AtomicInteger();
    this.utilities.setearBase(combinaciones);
    List<String> lineas = new ArrayList<>();
    var horizontal = new StringBuilder();
    var vertical = new StringBuilder();
    var diagonalAscendente1 = new StringBuilder();
    var diagonalAscendente2 = new StringBuilder();
    var diagonalDescendente1 = new StringBuilder();
    var diagonalDescendente2 = new StringBuilder();
    for (var row = 0; row < dna.length; row++) {
      horizontal.setLength(0);
      vertical.setLength(0);
      diagonalAscendente1.setLength(0);
      diagonalAscendente2.setLength(0);
      diagonalDescendente1.setLength(0);
      diagonalDescendente2.setLength(0);
      for (var column = 0; column < dna[0].length; column++) {
        int indice = row + column;

        horizontal.append(dna[row][column]);
        vertical.append(dna[column][row]);

        if (indice < dna.length) diagonalDescendente1.append(dna[indice][column]);

        if (indice + 1 < dna[0].length) diagonalDescendente2.append(dna[column][indice + 1]);

        if (dna.length - 1 - column >= 0 && indice + 1 < dna[0].length)
          diagonalAscendente1.append(dna[dna.length - 1 - column][indice + 1]);

        if ((dna.length - 1 - column - row) >= 0)
          diagonalAscendente2.append(dna[dna.length - 1 - column - row][column]);
      }
      lineas.addAll(
          List.of(
              horizontal.toString(),
              vertical.toString(),
              diagonalDescendente1.toString(),
              diagonalDescendente2.toString(),
              diagonalAscendente1.toString(),
              diagonalAscendente2.toString()));
    }

    combinaciones.forEach(
        (key, value) -> {
          int size = lineas.stream().filter(linea -> linea.contains(key)).toList().size();
          cont.getAndAdd(size);
          combinaciones.put(key, size);
        });

    auditoriaService.insertarAuditoria(this.obtenerDatosAuditoria(dna, cont.get() > 1));
    return cont.get() > 1;
  }

  private AuditoriaDto obtenerDatosAuditoria(String[][] dna, boolean isMutant) {
    return AuditoriaDto.builder()
        .dna(Arrays.deepToString(dna))
        .combinaciones(String.valueOf(combinaciones))
        .isMutant(isMutant ? 1 : 0)
        .build();
  }
  ;
}
