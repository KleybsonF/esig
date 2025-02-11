package esig.repository;

import java.util.List;

import esig.model.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SchemaGeneration {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		
		EntityManager em = emf.createEntityManager();
		
		List<Tarefa> lista = em.createQuery("from Tarefa", Tarefa.class)
				.getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}

}
