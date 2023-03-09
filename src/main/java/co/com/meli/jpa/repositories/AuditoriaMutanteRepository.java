package co.com.meli.jpa.repositories;


import co.com.meli.dto.StatsOutInterface;
import co.com.meli.jpa.entities.AuditoriaMutanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditoriaMutanteRepository extends JpaRepository<AuditoriaMutanteEntity, Long> {

    @Query(value = "SELECT" +
            "COUNT(DISTINCT CASE WHEN ISMUTANT = 0 THEN ID END) AS COUNT_MUTANT_DNA," +
            "COUNT(DISTINCT CASE WHEN ISMUTANT = 1 THEN ID END) AS COUNT_HUMAN_DNA," +
            "0.4 AS RATIO" +
            "FROM AUDITISMUTANT", nativeQuery = true)
    Optional<StatsOutInterface> findStats();

    @Query
    Optional<List<AuditoriaMutanteEntity>> findByDna(String dna);
}
