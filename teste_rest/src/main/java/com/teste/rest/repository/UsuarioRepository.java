package com.teste.rest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teste.rest.model.Usuario;

/**
 * Interface que implementa os métodos de CRUD
 * @author Alexandre
 *
 */

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	
}
