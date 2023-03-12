package co.com.meli.services.implementation;

import co.com.meli.dto.AuditoriaDto;
import co.com.meli.jpa.entities.AuditoriaMutanteEntity;
import co.com.meli.jpa.repositories.AuditoriaMutanteRepository;
import co.com.meli.services.IAuditoriaService;
import co.com.meli.utilities.exceptions.BussinessException;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditoriaService implements IAuditoriaService {

  private final AuditoriaMutanteRepository repository;

  @Override
  public void insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException {
    if (this.obtenerRegistro(auditoriaDto.getDna()))
      repository.save(
          AuditoriaMutanteEntity.builder()
              .id(UUID.randomUUID().toString())
              .ismutant(auditoriaDto.getIsMutant())
              .dna(auditoriaDto.getDna())
              .combinaciones(auditoriaDto.getCombinaciones())
              .date(new Date())
              .build());
  }

  @Override
  public boolean obtenerRegistro(String dna) {
    return repository.findByDna(dna).get().isEmpty();
  }
}
