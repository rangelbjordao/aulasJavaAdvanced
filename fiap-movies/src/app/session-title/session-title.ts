import { Component, input } from '@angular/core';

@Component({
  selector: 'session-title',
  imports: [],
  templateUrl: './session-title.html',
})
export class SessionTitle {
  text = input<string>();
}
