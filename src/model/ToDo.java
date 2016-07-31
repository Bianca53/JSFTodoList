package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Embeddable
public class ToDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "status", unique = false, length = 128, nullable = false)
	private boolean status;

	@Column(name = "text", unique = false, length = 200, nullable = false)
	private String text;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idList", nullable = false)
	private ToDoList toDoList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isStatus() {
		return status;
	}

	public ToDoList getToDoList() {
		return toDoList;
	}

	public void setToDoList(ToDoList toDoList) {
		this.toDoList = toDoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
