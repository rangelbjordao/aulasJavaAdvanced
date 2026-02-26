import { Component, inject } from '@angular/core';
import { SuperpowersService } from '../services/superpowers';
import { toSignal } from '@angular/core/rxjs-interop';
import { CardPower } from '../components/card-power/card-power';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'powers-list',
  standalone: true, // importante para poder usar imports
  imports: [CommonModule, CardPower], // << adiciona CommonModule
  templateUrl: './powers-list.html',
})
export class PowersList {
  private service = inject(SuperpowersService);

  powers = toSignal(this.service.getSuperPowers());
}
