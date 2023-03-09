package co.com.meli.controllers;

import co.com.meli.dto.StatsOutDto;
import co.com.meli.services.IStatsService;
import co.com.meli.utilities.Constantes;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(Constantes.STATS)
@Slf4j
@RequiredArgsConstructor
public class StatsController {

    private final IStatsService service;

    @GetMapping
    @Operation(description = "Servicio que retorna si un codigo de adn es mutante o no.")
    public ResponseEntity<StatsOutDto> getStats() {
        return ResponseEntity.ok(service.getStats());
    }
}
