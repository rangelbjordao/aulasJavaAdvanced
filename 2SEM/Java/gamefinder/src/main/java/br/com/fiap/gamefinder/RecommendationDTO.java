package br.com.fiap.gamefinder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationDTO {
    private String gameName;
    private String recommendation;
    private String stars;
    private String explanation;
}
