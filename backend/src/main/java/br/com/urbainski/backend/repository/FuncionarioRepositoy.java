package br.com.urbainski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.urbainski.backend.entity.Funcionario;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
public interface FuncionarioRepositoy extends JpaRepository<Funcionario, Long>{

}