import { Component, inject } from '@angular/core';
import { ApiService } from '../service/api.service';
import { toSignal } from '@angular/core/rxjs-interop';
import { MovieItem } from '../movie-item/movie-item';

@Component({
  selector: 'app-home',
  imports: [MovieItem],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  private service = inject(ApiService);

  movies = toSignal(this.service.getMovies());
}
