package br.com.fiap.gamefinder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationDTO {
    private String gameName;
    private String recommendation; // "Altamente Recomendado", etc.
    private String stars;          // "⭐⭐⭐"
    private String explanation;    // Texto justificando a nota
}
