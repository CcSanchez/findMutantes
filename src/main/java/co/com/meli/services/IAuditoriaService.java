package co.com.meli.services;

import co.com.meli.dto.AuditoriaDto;
import co.com.meli.utilities.exceptions.BussinessException;

public interface IAuditoriaService {

  void insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException;

  boolean obtenerRegistro(String dna);
}
