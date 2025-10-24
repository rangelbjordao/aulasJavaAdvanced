package com.weather.weather.controller;

import com.weather.weather.Previsao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping
public class RestController {
    private String amanha;
    private Double maxTemp;
    private Double minTemp;
    private Integer rainPossibility;

    @GetMapping("amanha")
    public ResponseEntity<?> previsaoAmanha() {

        RestTemplate rest = new RestTemplate();
        String uri = "https://api.open-meteo.com/v1/forecast?forecast_days=1&&latitude=-23.55&longitude=-46.63&hourly=temperature_2m,precipitation&timezone=America%2FSao_Paulo";
        Response response = rest.getForObject(URI.create(uri), Response.class);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


        Previsao previsao = new Previsao(amanha, maxTemp, minTemp, rainPossibility);
        return new ResponseEntity<>(previsao, HttpStatus.OK);
    }

    public record Response(Hourly hourly) {
    }

    public record Hourly(List<String> time) {
    }


}
