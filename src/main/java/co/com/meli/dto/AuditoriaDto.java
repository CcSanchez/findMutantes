package co.com.meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriaDto {

  @Schema(description = "Indicador de si el adn es mutante o no", required = true, example = "1")
  @JsonProperty("isMutant")
  private int isMutant;

  @Schema(
      description = "Secuencia de adn",
      required = true,
      example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]")
  @JsonProperty("dna")
  private String dna;
}
