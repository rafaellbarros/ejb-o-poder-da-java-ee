package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER) // opcional
@TransactionManagement(TransactionManagementType.BEAN)
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	UserTransaction tx;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED) // opcional
	// @TransactionAttribute(TransactionAttributeType.MANDATORY)
	// @TransactionAttribute(TransactionAttributeType.NEVER)
	public void salva(Autor autor) {
		try {
			tx.begin();
			manager.persist(autor);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
