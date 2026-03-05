import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GameCard } from './game-card/game-card';
import { RecommendationModel } from '../models/recommendation.model';
import { GameService } from './services/game.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GameCard],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  gameService = inject(GameService);

  recommendation = signal<RecommendationModel | null>(null);

  jogos = ['need-for-speed', 'cyberpunk', 'gollum'];

  buscar(slug: string) {
    this.gameService.getRecommendation(slug).subscribe((res) => this.recommendation.set(res));
  }
}
