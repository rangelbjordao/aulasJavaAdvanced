import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SessionTitle } from './session-title/session-title';
import { CardMovie } from './card-movie/card-movie';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SessionTitle, CardMovie],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('fiap-movies');
}
