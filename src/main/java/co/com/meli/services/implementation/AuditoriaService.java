package co.com.meli.services.implementation;

import co.com.meli.dto.AuditoriaDto;
import co.com.meli.jpa.entities.AuditoriaMutanteEntity;
import co.com.meli.jpa.repositories.AuditoriaMutanteRepository;
import co.com.meli.services.IAuditoriaService;
import co.com.meli.utilities.Constantes;
import co.com.meli.utilities.exceptions.BussinessException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuditoriaService implements IAuditoriaService {

  private final AuditoriaMutanteRepository repository;

  @Override
  public boolean insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException {
    try {
      Optional<List<AuditoriaMutanteEntity>> auditoriaMutanteEntities =
          repository.findByDna(auditoriaDto.getDna());
      if (auditoriaMutanteEntities.isPresent()) return true;

      var auditoriaMutanteEntity = new AuditoriaMutanteEntity();
      auditoriaMutanteEntity.setDate(new Date());
      auditoriaMutanteEntity.setDna(auditoriaDto.getDna());
      auditoriaMutanteEntity.setIsmutant((long) auditoriaDto.getIsMutant());
      repository.save(auditoriaMutanteEntity);

      return true;
    } catch (Exception e) {
      throw new BussinessException(Constantes.ERROR_AUDITORIA);
    }
  }
}
