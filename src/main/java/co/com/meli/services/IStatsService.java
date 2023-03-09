package co.com.meli.services;


import co.com.meli.dto.StatsOutDto;

public interface IStatsService {

    /**
     * Metodo que retorna las estadisticas
     *
     * @return dto con los datos solicitados
     */
    public StatsOutDto getStats();
}
