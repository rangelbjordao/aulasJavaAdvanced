package br.com.fiap.gamefinder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

@Service
public class GameService {

    @Value("${rawg.api.key}")
    private String apiKey;

    @Value("${rawg.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public RecommendationDTO getGameRecommendation(String slug) {
        // Monta a URL: https://api.rawg.io/api/games/nome-do-jogo?key=SUA_CHAVE
        String url = String.format("%s/%s?key=%s", apiUrl, slug, apiKey);

        RawgResponseDTO rawData = restTemplate.getForObject(url, RawgResponseDTO.class);

        return applyBusinessRules(rawData);
    }

    private RecommendationDTO applyBusinessRules(RawgResponseDTO game) {
        int releaseYear = Integer.parseInt(game.getReleased().substring(0, 4));
        int currentYear = LocalDate.now().getYear();
        boolean isRecent = (currentYear - releaseYear) <= 10;

        // Regra ⭐⭐⭐
        if (game.getRating() >= 4.5 && game.getRatings_count() > 1000 && isRecent) {
            return new RecommendationDTO(game.getName(), "Altamente Recomendado", "⭐⭐⭐",
                    "Este jogo é um sucesso atual com excelentes críticas.");
        }

        // Regra ⭐⭐
        if (game.getRating() >= 3.5) {
            return new RecommendationDTO(game.getName(), "Vale a pena", "⭐⭐",
                    "Uma experiência sólida, embora possa ter alguns anos ou nicho menor.");
        }

        // Regra ⭐
        return new RecommendationDTO(game.getName(), "Melhor ver um filme", "⭐",
                "A popularidade ou a nota média não justificam o investimento de tempo agora.");
    }
}
