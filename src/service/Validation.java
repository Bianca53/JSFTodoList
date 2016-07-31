package service;

import java.io.Serializable;
import model.ToDoList;
import model.ToDo;
import repository.ListDAO;
import repository.ToDoDAO;

public class Validation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ToDoDAO toDoDAO;
	ListDAO listDAO;

	boolean checkToDo(ToDo toDo) {
		toDoDAO = new ToDoDAO();
		if (toDo.getText().equals("") || toDo.getText().length() > 30 || toDo.getText().length() < 3) {
			System.out.println("the text field must to be 3 to 30 characters");
			return false;
		}
		return true;
	}

	boolean checkToDoUpdate(String text) {
		if (text.length() < 3 || text.length() > 30 || text.equals("")) {
			return false;
		}
		return true;
	}

	boolean checkList(ToDoList list) {
		listDAO = new ListDAO();
		for (ToDoList lists : listDAO.listing()) {
			if (list.getTitle().equals(lists.getTitle())) {
				System.out.println("the title already exists!");
				return false;
			}
		}
		if (list.getTitle().equals("") || list.getTitle().length() > 20 || list.getTitle().length() < 3) {
			System.out.println("this field must to be 3 to 20 characters");
			return false;
		}
		return true;
	}

	boolean checkListUpdate(String title) {
		listDAO = new ListDAO();
		for (ToDoList lists : listDAO.listing()) {
			if (title.equals(lists.getTitle())) {
				return false;
			}
		}
		if (title.equals("") || title.length() > 20 || title.length() < 3) {
			System.out.println("this field must to be 3 to 20 characters");
			return false;
		}
		return true;
	}
}
