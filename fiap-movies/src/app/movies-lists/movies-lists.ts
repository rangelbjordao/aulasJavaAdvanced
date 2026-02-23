import { Component, inject } from '@angular/core';
import { CardMovie } from '../card-movie/card-movie';
import { MovieService } from '../services/movie.service';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'movies-list',
  imports: [CardMovie],
  templateUrl: './movies-lists.html',
})
export class MoviesList {
  service = inject(MovieService);

  movies = toSignal(this.service.getMovies());
}
