import { Component, input } from '@angular/core';

@Component({
  selector: 'app-card-product',
  imports: [],
  templateUrl: './card-product.html',
  styleUrl: './card-product.css',
})
export class CardProduct {
  imageUrl = input<string>();
  title = input<string>();
  description = input<string>();
  promotion = input<string>();
  button = input<string>();
}
