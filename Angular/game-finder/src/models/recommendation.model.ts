import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface RecommendationModel {
  nome: string;
  score: number;
  texto: string;
}

@Injectable({ providedIn: 'root' })
export class GameService {
  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/api/recommendations';

  getRecommendation(slug: string): Observable<RecommendationModel> {
    return this.http.get<RecommendationModel>(`${this.apiUrl}/${slug}`);
  }
}
