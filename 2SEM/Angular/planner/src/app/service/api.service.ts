import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ApiService {
  http = inject(HttpClient);
  readonly apiUrl = 'http://localhost:8080/api/planner';

  getPlanner(activity: string) {
    return this.http.get(`${this.apiUrl}?activity=${activity}`);
  }
}
