import { Component, input } from '@angular/core';

@Component({
  selector: 'app-movie-item',
  imports: [],
  templateUrl: './movie-item.html',
  styleUrl: './movie-item.css',
})
export class MovieItem {
  id = input<number>();
  title = input<string>();
  platform = input<string>();
  watched = input<boolean>();
}
