package esig.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import esig.model.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class Tarefas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em; // EntityManager para manipular o banco de dados
	
	@Inject
	private EntityManager manager;
	
	public Tarefas() {
		
	}
	
	public Tarefas(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salvar(Tarefa tarefa) {
        em.persist(tarefa); // Persiste a tarefa no banco de dados
    }
	
	public Tarefa get(Long numero) {
		return manager.find(Tarefa.class, numero);
	}
	
	public List<Tarefa> getSituacao(String situacao) {
		TypedQuery<Tarefa> query = manager.createQuery("from Tarefa where situacao like :situacao", Tarefa.class);
		query.setParameter("situacao", situacao + "%");
		return query.getResultList();
	}
	
	
	public Tarefa save(Tarefa tarefa) {
		return manager.merge(tarefa);
	}
	
	public void remove(Tarefa tarefa) {
		tarefa = get (tarefa.getNumero());
		manager.remove(tarefa);
	}
	
}
