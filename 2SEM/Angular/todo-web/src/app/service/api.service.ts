import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface Todo {
  id: number;
  description: string;
  completed: boolean;
}

@Injectable({providedIn: 'root'})
export class ApiService{
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/todos';

  getTodos(): Observable<Todo[]>   {
    return this.http.get<Todo[]>(this.baseUrl)
  }

  //postTodo(todo: Todo): Observable<Todo> {
    // para próxima aula
  //}
}
