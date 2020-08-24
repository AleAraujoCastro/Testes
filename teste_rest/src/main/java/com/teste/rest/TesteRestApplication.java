package com.teste.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe resposável por fazer a ativação de todos os recursos necessários
 * @author Alexandre
 *
 */

@SpringBootApplication //Levanta o servidor e traz configurações
@EnableAutoConfiguration //Configuração Automática do Projeto
@EntityScan(basePackages = {"com.teste.rest.model"}) //Chama as classes do pacote model e cria as tabelas automaticamente
@ComponentScan(basePackages = {"com.teste.rest.controller"}) //Varre todo o projeto e faz a injeção de dependências
@EnableJpaRepositories(basePackages = "com.teste.rest.repository") //Habilita as Persistências
@EnableTransactionManagement //Controla as transações para evitar erros.
@EnableWebMvc //Habilitando a estrura MVC
@RestController //Habilita o REST - Retornando em JSON
@EnableJpaAuditing
public class TesteRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteRestApplication.class, args);
	}
	
	
}
