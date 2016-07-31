package service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.ToDo;
import model.ToDoList;
import repository.ToDoDAO;

public class ToDoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ToDoDAO todoDAO = new ToDoDAO();
	private Validation verify = new Validation();
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public boolean insert(ToDo toDo, ToDoList toDoList, String idString)throws ParseException {
		if (verify.checkToDo(toDo)) {
			toDoList.setId(Integer.parseInt(idString));
			toDo.setToDoList(toDoList);
			toDo.setStatus(false);
			todoDAO.insert(toDo);
			return true;
		} else {
			return false;
		}
	}

	public boolean update(String idStringToDo, String text) {
		if (verify.checkToDoUpdate(text)) {
			int id = Integer.parseInt(idStringToDo);
			todoDAO.update(id, text);
			return true;
		} else {
			return false;
		}
	}

	public void updateStatus(List<ToDo> toDos) {

		todoDAO.updateStatus(toDos);
	}

	public void delete(String idString) {
		int id = Integer.parseInt(idString);
		todoDAO.delete(id);
	}

	public List<ToDo> listing(String idString) {

		return todoDAO.listing(idString);

	}

	public ToDoDAO getTodoDAO() {
		return todoDAO;
	}

	public void setTodoDAO(ToDoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}

	public Validation getVerify() {
		return verify;
	}

	public void setVerify(Validation verify) {
		this.verify = verify;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

}
