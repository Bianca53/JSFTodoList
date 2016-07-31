package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.ToDoService;
import model.ToDo;
import model.ToDoList;

@ManagedBean(name = "ToDoMBean")
@SessionScoped
public class ToDoMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ToDo toDo = new ToDo();
	private boolean status;
	private String idStringToDo;
	private String textToDo;
	private String message = "gfg";
	private String idStringList;
	private ToDoList toDoList = new ToDoList();
	private List<ToDo> toDos;
	private ToDoService service = new ToDoService();

	public ToDoMBean() {

	}

	public String insert() throws ParseException {
		if (service.insert(toDo, toDoList, idStringList)) {
			toDo = new ToDo();
			message = "Sucessfull!";
			return updateListing();
		} else {
			return "";
		}

	}

	public String redirectUpdate() {
		return "updateToDo?faces-redirect=true";
	}

	public String update() {
		if (service.update(idStringToDo, textToDo)) {
			message = "Sucessfull!";
			return updateListing();
		} else {
			return "";
		}
	}

	public String updateStatusCheckbox() {
		service.updateStatus(toDos);
		message = "Sucessfull!";
		return listing();
	}

	public String delete() {
		service.delete(idStringToDo);
		idStringToDo = null;
		message = "Sucessfull!";
		return updateListing();
	}

	public String updateListing() {
		toDos = service.listing(idStringList);
		return "todolist?faces-redirect=true";
	}

	public String listing() {
		toDos = service.listing(idStringList);
		idStringToDo = null;
		message = "";
		return "todolist?faces-redirect=true";
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}

	public List<ToDo> getToDos() {
		return toDos;
	}

	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
	}

	public ToDoService getService() {
		return service;
	}

	public void setService(ToDoService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ToDoList getToDoList() {
		return toDoList;
	}

	public void setToDoList(ToDoList toDoList) {
		this.toDoList = toDoList;
	}

	public String getTextToDo() {
		return textToDo;
	}

	public void setTextToDo(String textToDo) {
		this.textToDo = textToDo;
	}

	public String getIdStringList() {
		return idStringList;
	}

	public void setIdStringList(String idStringList) {
		this.idStringList = idStringList;
	}

	public String getIdStringToDo() {
		return idStringToDo;
	}

	public void setIdStringToDo(String idStringToDo) {
		this.idStringToDo = idStringToDo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
