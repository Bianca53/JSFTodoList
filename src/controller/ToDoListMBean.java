package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.ListService;
import model.ToDoList;

@ManagedBean(name = "ToDoListMBean")
@SessionScoped
public class ToDoListMBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private ListService listService = new ListService();
	private String title = "";
	private String id;
	private String message = "";
	private ToDoList list = new ToDoList();
	private List<ToDoList> lists;
	private String teste;

	public ToDoListMBean() {

	}

	public String insert() {
		if (listService.insert(list)) {
			list = new ToDoList();
			message = "Sucessfull!";
			return "index?faces-redirect=true";
		} else {
			return "";
		}
	}

	public String redirectUpdate() {
		return "updateToDoList?faces-redirect=true";
	}

	public String update() {
		if (listService.update(id, title)) {
			message = "Sucessfull!";
			return "index?faces-redirect=true";
		} else {
			return "";
		}
	}

	public String delete() {
		listService.delete(id);
		message = "Sucessfull!";
		return "index?faces-redirect=true";
	}

	public List<ToDoList> listing() {
		lists = listService.listing();
		message = "";
		return lists;
	}

	public ListService getListService() {
		return listService;
	}

	public void setListService(ListService listService) {
		this.listService = listService;
	}

	public ToDoList getList() {
		return list;
	}

	public void setList(ToDoList list) {
		this.list = list;
	}

	public List<ToDoList> getLists() {
		return lists;
	}

	public void setLists(List<ToDoList> lists) {
		this.lists = lists;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}