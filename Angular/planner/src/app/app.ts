import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Card } from './card/card';
import { ApiService } from './service/api.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Card],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  ApiService = inject(ApiService);
  protected readonly title = signal('planner');
  apiResponse = signal<string>('');

  handleCardClick(activity: string) {
    this.ApiService.getPlanner(activity).subscribe({
      next: (response) => this.apiResponse.set(response as string),
      error: (error) => this.apiResponse.set('Erro ao buscar atividade.' + error.message),
    });
  }
}
