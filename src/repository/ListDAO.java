package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.ToDoList;

public class ListDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
	private EntityManager em = factory.createEntityManager();

	public void update(int id, String title) {
		em.getTransaction().begin();
		ToDoList todoList = em.find(ToDoList.class, id);
		todoList.setTitle(title);
		em.merge(todoList);
		em.getTransaction().commit();
	}

	public void delete(int id) {
		em.getTransaction().begin();
		ToDoList todoList = em.find(ToDoList.class, id);
		todoList.setToDos(null);
		em.merge(todoList);
		em.getTransaction().commit();
		remove(todoList);

	}

	public void updateStatus(ToDoList toDoList) {
		em.getTransaction().begin();
		em.merge(toDoList);
		em.getTransaction().commit();
	}

	public void remove(ToDoList todoList) {
		em.getTransaction().begin();
		em.remove(todoList);
		em.getTransaction().commit();
	}

	public void insert(ToDoList list) {
		try {
			em.getTransaction().begin();
			em.persist(list);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ToDoList> listing() {
		em.getTransaction().begin();
		Query select = em.createQuery("select list from ToDoList list");
		List<ToDoList> lists = select.getResultList();
		em.getTransaction().commit();
		return lists;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
