package br.com.fiap.gamefinder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:4200") // Importante para o Angular
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{slug}")
    public RecommendationDTO getRecommendation(@PathVariable String slug) {
        return gameService.getGameRecommendation(slug);
    }
}