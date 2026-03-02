import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { MovieResponse } from '../models/movie.model';
import { map } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class MovieService {
  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/movies';

  getMovies() {
    return this.http
      .get<MovieResponse>(this.apiUrl)
      .pipe(map((response) => response._embedded.movies ?? []));
  }
}
