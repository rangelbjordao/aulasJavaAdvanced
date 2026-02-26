import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Power, PowerResponse } from '../models/power.model';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SuperpowersService {
  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/superpowers';

  getSuperPowers(): Observable<Power[]> {
    return this.http
      .get<PowerResponse>(this.apiUrl)
      .pipe(map((response) => response._embedded.powers));
  }
}
