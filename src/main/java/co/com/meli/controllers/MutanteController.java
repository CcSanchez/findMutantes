package co.com.meli.controllers;

import co.com.meli.dto.MutantInDto;
import co.com.meli.services.IMutantesService;
import co.com.meli.utilities.Constantes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constantes.MUTANT)
@Slf4j
public class MutanteController {

  @Autowired IMutantesService service;

  @PostMapping
  @ResponseBody
  @Operation(description = "Servicio que retorna si un codigo de adn es mutante o no.")
  public ResponseEntity<String> getMutant(
      @Parameter(
              name = "dna",
              example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]",
              required = true)
          @RequestBody
          MutantInDto adn) {

    try {
      if (service.isMutant(adn.getDna())) return ResponseEntity.ok(Constantes.DNA_MUTANTE);

      return new ResponseEntity<>(Constantes.DNA_NO_MUTANTE, HttpStatus.FORBIDDEN);

    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }
  }
}
