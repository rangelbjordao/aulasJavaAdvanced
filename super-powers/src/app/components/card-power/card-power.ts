import { Component, input } from '@angular/core';
import { Power } from '../../models/power.model';

@Component({
  selector: 'app-card-power',
  imports: [],
  templateUrl: './card-power.html',
  styleUrl: './card-power.css',
})
export class CardPower {
  power = input.required<Power>();
}
