package repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.ToDo;

public class ToDoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
	private EntityManager em = factory.createEntityManager();

	public void insert(ToDo toDo) {
		try {
			em.getTransaction().begin();
			em.persist(toDo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void update(int id, String text) {
		em.getTransaction().begin();
		ToDo todo = em.find(ToDo.class, id);
		todo.setText(text);
		em.merge(todo);
		em.getTransaction().commit();
	}

	public void updateStatus(List<ToDo> toDos) {
		em.getTransaction().begin();
		for (ToDo todo : toDos) {
			em.merge(todo);
			em.getTransaction().commit();
		}
	}

	public void delete(int id) {
		em.getTransaction().begin();
		ToDo todo = em.find(ToDo.class, id);
		em.remove(todo);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<ToDo> listing(String id) {
		em.getTransaction().begin();
		Query select = em.createQuery("select toDo from ToDo toDo where idList = :id");
		select.setParameter("id", id);
		List<ToDo> toDos = select.getResultList();
		em.getTransaction().commit();

		return toDos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
