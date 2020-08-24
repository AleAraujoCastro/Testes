package com.teste.rest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.rest.model.Usuario;
import com.teste.rest.repository.UsuarioRepository;


/**
 * Classe para teste de funcionamento de controller
 * @author Alexandre
 *
 */

@RestController //Arquitetura REST
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping(value = "/", produces = "application/json") //Método para cadastrar Cliente
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioCreat = usuarioRepository.save(usuario);
		
		return new ResponseEntity<>(usuarioCreat, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/", produces = "application/json") //Método para atualizar cadastro de Cliente
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		Usuario usuarioCreat = usuarioRepository.save(usuario);
		
		return new ResponseEntity<>(usuarioCreat, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}", produces = "application/json") //Método para consultar um usuário em específico
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/", produces = "application/json") //Método que retorna uma consulta da lista de usuário.
	public ResponseEntity<List<Usuario>> usuario(){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = "application/text") //Método para deletar um usuário em específico
	public String deletarCliente(@PathVariable(value = "id") Long id) {
		
		usuarioRepository.deleteById(id);
		
		
		return "OK!";
	}
	
	

}
