import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PowersList } from './powers-list/powers-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PowersList],
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('super-powers');
}
