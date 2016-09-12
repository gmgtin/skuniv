package winder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import winder.vo.TodoListVO;

public interface TodoListDAO {
	public int insertTodoList(TodoListVO todoList) throws RuntimeException;
	public int deleteTodoList(int tlno);
	public int updateTodoList(TodoListVO todoList);
	public List<HashMap<String, String>> selectTodoList(int pno);
	public List<TodoListVO> selectAllTodoList();
}
