package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.exceptions.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao dao;
	
	// required
	public void adiciona(Autor autor) {
		// mais regras aqui
		
		dao.salva(autor);
		
		// uma regra de negocio de errado
		
		throw new LivrariaException();
		
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
}
