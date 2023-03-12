package co.com.meli.services;

import java.util.Map;

public interface IUtilitiesService {

  boolean validarMutante(int cont);

  public void validarLonguitud(String row, Integer size);

  public void validarBase(String row);

  public void setearBase(Map<String, Integer> combinaciones);
}
