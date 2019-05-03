package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bo.Todo;

@Repository
public class TodoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_ALL_TODOS_BY_USER = "select id,username,description,target_date,is_done from todos where username=?";
	private final String SQL_FIND_TODO_BY_ID = "select id,username,description,target_date,is_done from todos where id=? and username=?";
	private final String SQL_DELETE_TODO_BY_ID = "delete from todos where id=?";
	private final String SQL_UPDATE_TODO_BY_ID = "update todos set is_done=? where id=?";
	private final String SQL_INSERT_TODO = "insert into todos(username,description,target_date,is_done) values(?,?,?,?)";

	public List<Todo> getAllTodos(final String username) {
		List<Todo> allTodos = null;
		allTodos = jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstStatement = con.prepareStatement(SQL_FIND_ALL_TODOS_BY_USER);
				pstStatement.setString(1, username);
				return pstStatement;
			}
		}, new TodoRowMapper());

		return allTodos;
	}

	private final class TodoRowMapper implements RowMapper<Todo> {

		@Override
		public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Todo todo = null;

			todo = new Todo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5));
			return todo;
		}

	}

	public int addTodo(Todo todo) {
		int result = -1;

		result = jdbcTemplate.update(SQL_INSERT_TODO,
				new Object[] { todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isIsDone() });

		return result;
	}

	public Todo getTodoById(long id, String username) {
		Todo todo = null;

		todo = jdbcTemplate.queryForObject(SQL_FIND_TODO_BY_ID, new Object[] { id, username }, new TodoRowMapper());
		return todo;
	}

	public int deleteTodoById(long id) {
		int result = -1;
		result = jdbcTemplate.update(SQL_DELETE_TODO_BY_ID, new Object[] { id });
		return result;
	}

	public int updateTodoById(long id, boolean status) {
		int result = -1;
		result = jdbcTemplate.update(SQL_UPDATE_TODO_BY_ID, new Object[] { status, id });
		return result;
	}
}
