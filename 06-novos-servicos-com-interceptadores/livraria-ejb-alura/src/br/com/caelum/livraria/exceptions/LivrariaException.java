package br.com.caelum.livraria.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

}
