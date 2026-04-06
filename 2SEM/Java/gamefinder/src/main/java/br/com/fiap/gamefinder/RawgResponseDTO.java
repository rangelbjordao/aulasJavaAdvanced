package br.com.fiap.gamefinder;

import lombok.Data;

@Data
public class RawgResponseDTO {
    private String name;
    private Double rating;
    private Integer ratings_count;
    private String released;
}