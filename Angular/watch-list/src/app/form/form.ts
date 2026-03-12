import { Component, inject } from '@angular/core';

import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { ApiService, Movie } from '../service/api.service';

@Component({
  selector: 'app-form',

  imports: [ReactiveFormsModule],

  templateUrl: './form.html',
})
export class Form {
  private apiService = inject(ApiService);

  form = new FormGroup({
    title: new FormControl(''),

    platform: new FormControl(''),

    watched: new FormControl(false),
  });

  submit() {
    const movie = this.form.value as Omit<Movie, 'id'>;

    this.apiService.postMovies(movie).subscribe({
      next: (res) => {
        console.log('Filme criado:', res);
        alert("Filme cadastrado")
      },

      error: (err) => {
        console.error('Erro:', err);
      },
    });
  }
}
