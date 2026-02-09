import { Component, input } from '@angular/core';

@Component({
  selector: 'app-card-movie',
  imports: [],
  templateUrl: './card-movie.html',
  styleUrl: './card-movie.css',
})
export class CardMovie {
  postUrl = input<string>();
  title = input<string>();
  rating = input<string>();
}
