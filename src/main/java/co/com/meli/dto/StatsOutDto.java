package co.com.meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsOutDto {

  @JsonProperty("count_mutant_dna")
  @JsonDeserialize
  Long countMutantDna;

  @JsonProperty("count_human_dna")
  @JsonDeserialize
  Long countHumanDna;

  @JsonProperty("ratio")
  @JsonDeserialize
  Long ratio;
}
