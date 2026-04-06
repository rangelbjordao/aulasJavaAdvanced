import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CardProduct } from './card-product/card-product';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CardProduct],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ecommerce');
}
