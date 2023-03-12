package co.com.meli.services.implementation;

import co.com.meli.services.IUtilitiesService;
import co.com.meli.utilities.Constantes;
import co.com.meli.utilities.exceptions.BussinessException;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class UtilitiesService implements IUtilitiesService {
  @Override
  public boolean validarMutante(int cont) {
    return cont > 1;
  }

  @Override
  public void validarLonguitud(String row, Integer size) {
    if ((row.length() != size || row.length() < 4))
      throw new BussinessException(Constantes.ERROR_DNA_LONGUITUD);
  }

  @Override
  public void validarBase(String row) {
    for (char item : row.toCharArray())
      if (Arrays.stream(Constantes.BASESNITROGENADAS)
          .noneMatch(base -> base.equals(String.valueOf(item))))
        throw new BussinessException(Constantes.ERROR_DNA_ERRONEO);
  }
}
