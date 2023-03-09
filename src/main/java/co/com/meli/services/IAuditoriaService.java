package co.com.meli.services;


import co.com.meli.dto.AuditoriaDto;
import co.com.meli.utilities.exceptions.BussinessException;

public interface IAuditoriaService {

    boolean insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException;
}
