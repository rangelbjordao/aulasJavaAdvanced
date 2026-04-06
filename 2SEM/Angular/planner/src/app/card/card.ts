import { Component, computed, input, output } from '@angular/core';
import { Balloon, LucideAngularModule, MoonStar, TreePalm } from 'lucide-angular';

const icons = {
  moonStar: MoonStar,
  balloon: Balloon,
  treePalm: TreePalm,
};

export type IconName = keyof typeof icons;

@Component({
  selector: 'card',
  imports: [LucideAngularModule],
  templateUrl: './card.html',
})
export class Card {
  text = input.required<string>();
  icon = input<IconName>('balloon');
  cardClick = output<string>();
  iconImg = computed(() => icons[this.icon()]);

  onCardClick() {
    this.cardClick.emit(this.text());
  }
}
