package br.com.urbainski.backend.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.urbainski.backend.entity.Funcionario;
import br.com.urbainski.backend.service.FuncionarioService;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<Funcionario> save(@Valid @RequestBody Funcionario funcionario) {
		Funcionario saved = funcionarioService.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping
	public ResponseEntity<Funcionario> update(@Valid @RequestBody Funcionario funcionario) {
		try {
			Funcionario saved = funcionarioService.update(funcionario);
			return ResponseEntity.ok(saved);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(name = "id") Long idFuncionario) {
		funcionarioService.delete(idFuncionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findOne(@PathVariable(name = "id") Long idFuncionario) {
		Funcionario funcionario = funcionarioService.findOne(idFuncionario);
		if (funcionario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}

	@GetMapping
	public Page<Funcionario> findAll(Pageable pageable) {
		return funcionarioService.findAll(pageable);
	}

}