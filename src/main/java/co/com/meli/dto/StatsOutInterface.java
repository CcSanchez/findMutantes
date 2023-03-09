package co.com.meli.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public interface StatsOutInterface {

  @JsonDeserialize
  Long getcount_mutant_dna();

  @JsonDeserialize
  Long getcount_human_dna();

  @JsonDeserialize
  Long getratio();
}
