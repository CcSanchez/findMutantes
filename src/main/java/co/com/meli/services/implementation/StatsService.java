package co.com.meli.services.implementation;

import co.com.meli.dto.StatsOutDto;
import co.com.meli.dto.StatsOutInterface;
import co.com.meli.jpa.repositories.AuditoriaMutanteRepository;
import co.com.meli.services.IStatsService;
import co.com.meli.utilities.Constantes;
import co.com.meli.utilities.exceptions.BussinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsService implements IStatsService {

  private final AuditoriaMutanteRepository repository;

  /**
   * Metodo que retorna las estadisticas
   *
   * @return dto con los datos solicitados
   */
  @Override
  public StatsOutDto getStats() {
    StatsOutInterface statsOutInterface =
        repository
            .findStats()
            .orElseThrow(() -> new BussinessException(Constantes.STATS_NOT_FOUND));

    StatsOutDto statsOutDto = new StatsOutDto();
    statsOutDto.setCountHumanDna(statsOutInterface.getcount_human_dna());
    statsOutDto.setCountMutantDna(statsOutInterface.getcount_mutant_dna());
    statsOutDto.setRatio(statsOutInterface.getratio());
    return statsOutDto;
  }
}
