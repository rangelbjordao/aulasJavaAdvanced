import { Component, computed, input } from '@angular/core';

@Component({
  selector: 'game-card',
  imports: [],
  templateUrl: './game-card.html',
})
export class GameCard {
  nome = input.required<string>();
  score = input.required<number>();
  texto = input.required<string>();

  textoDisplay = computed(() => {
    return this.texto();
  });
}
