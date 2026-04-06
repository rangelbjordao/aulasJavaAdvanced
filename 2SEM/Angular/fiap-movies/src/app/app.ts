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
  movies = [
    {
      id: 1,
      title: 'Titanic',
      synopsis:
        'A história de amor entre Jack e Rose, a bordo do navio Titanic, que naufragou em 1912.',
      rating: 9.8,
      posterUrl: 'https://image.tmdb.org/t/p/original/As0zX43h3w6kD2NS4uVHu9HKdEh.jpg',
    },
    {
      id: 2,
      title: 'Mad Max: Estrada da Fúria',
      synopsis:
        'Em um mundo pós-apocalíptico, Max se une a Furiosa para escapar de um tirano e encontrar um lugar seguro.',
      rating: 8.1,
      posterUrl: 'https://image.tmdb.org/t/p/original/8tZYtuWezp8JbcsvHYO0O46tFbo.jpg',
    },
    {
      id: 3,
      title: 'F1 - O Filme',
      synopsis:
        'Sonny Hayes, a lenda do automobilismo, é persuadido a deixar a aposentadoria para liderar uma equipe de Fórmula 1 em dificuldades—e ser mentor de um jovem piloto famoso—enquanto busca mais uma oportunidade de glória.',
      rating: 7.8,
      posterUrl:
        'https://www.themoviedb.org/t/p/w600_and_h900_face/fMcY5hpVZQ0cLKHvFM1mo6GrAr0.jpg',
    },
  ];
}
