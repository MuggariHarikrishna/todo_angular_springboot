package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo.Todo;
import com.dao.TodoDao;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;

	public List<Todo> getAllTodos(final String username) {
		return todoDao.getAllTodos(username);
	}

	public Todo getTodoById(long id,String username) {
		return todoDao.getTodoById(id,username);
	}
	
	public int addTodo(Todo todo) {
		return todoDao.addTodo(todo);
	}
	public int deleteTodoById(long id) {
		return todoDao.deleteTodoById(id);
	}
	
	public int updateTodoById(long id,boolean status) {
		return todoDao.updateTodoById(id, status);
	}
}
