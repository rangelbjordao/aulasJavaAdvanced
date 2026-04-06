import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Movie {
  id: number;
  title: string;
  platform: string;
  watched: boolean;
}

@Injectable({ providedIn: 'root' })
export class ApiService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/movies';

  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseUrl);
  }

  postMovies(movieData: Omit<Movie, 'id'>): Observable<Movie> {
    return this.http.post<Movie>(this.baseUrl, movieData);
  }
}
