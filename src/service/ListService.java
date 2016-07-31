package service;

import java.io.Serializable;
import java.util.List;
import model.ToDoList;
import repository.ListDAO;

public class ListService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListDAO listDAO;
	private Validation verify;

	public ListService() {
		listDAO = new ListDAO();
		verify = new Validation();
	}

	public boolean insert(ToDoList list) {
		if (verify.checkList(list)) {
			listDAO.insert(list);
			return true;
		} else {
			return false;
		}
	}

	public boolean update(String idString, String title) {
		if (verify.checkListUpdate(title)) {
			int id = Integer.parseInt(idString);
			listDAO.update(id, title);
			return true;
		} else {
			return false;
		}
	}

	public void delete(String idString) {
		int id = Integer.parseInt(idString);
		listDAO.delete(id);
	}

	public List<ToDoList> listing() {
		return listDAO.listing();
	}
}
