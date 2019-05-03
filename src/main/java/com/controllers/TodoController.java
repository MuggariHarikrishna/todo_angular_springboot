package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bo.Todo;
import com.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public String check() {
		return "/GET Works";
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAll(@PathVariable("username") String username){
		List<Todo> allTodos=null;
		System.out.println("here");
		allTodos=todoService.getAllTodos(username);
		return allTodos;
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable("username") String username,@PathVariable("id") long id) {
		Todo todo=null;
		todo=todoService.getTodoById(id,username);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable("username") String username,@RequestBody Todo todo){
		int result=-1;
		result=todoService.addTodo(todo);
		System.out.println("todo :: "+todo+"\t Result :: "+result);
		if(result>0) {
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable("username") String username,@PathVariable("id") long id){
		int result=-1;
		result=todoService.deleteTodoById(id);
		if(result>0) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/users/{username}/todos/{todo_id}")
	public ResponseEntity<Void> updateTodoById(@PathVariable("username") String username,@PathVariable("todo_id") long id,@RequestParam("status") boolean status){
		int result=-1;
		result=todoService.updateTodoById(id, status);
		if(result>0) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	
}
