import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todo } from '../Todo';
@Injectable({
  providedIn: 'root'
})


export class DataService {
  api_url = 'http://localhost:3000/';
  constructor(private http: HttpClient) { }

  // getAllTodos(username) {
  //   return this.http.get<Todo[]>(`http://localhost:3000/users/${username}/todos`);
  // }
  post(url, body) {

  }
  get(url) {
    // const token = sessionStorage.getItem('authenticatedUser')
    return this.http.get(this.api_url + url);
  }

  // getTodoById(username,id){
  //   return this.http.get<Todo>(`http://localhost:3000/users/${username}}/todos/${id}`);
  // }
  // deleteTodoById(username,id){
  //   return this.http.delete<Todo>(`http://localhost:3000/users/${username}/todos/${id}`);
  // }
  // updateTodoById(username,id,status){
  //   return this.http.put<Todo>(`http://localhost:3000/users/${username}/todos/${id}?status=${status}`);
  // }
}
