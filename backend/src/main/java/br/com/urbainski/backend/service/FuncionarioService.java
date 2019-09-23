package br.com.urbainski.backend.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.urbainski.backend.entity.Funcionario;
import br.com.urbainski.backend.repository.FuncionarioRepositoy;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepositoy funcionarioRepositoy;

	@Transactional
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepositoy.save(funcionario);
	}

	@Transactional
	public Funcionario update(Funcionario funcionario) {
		Funcionario saved = findOne(funcionario.getIdFuncionario());
		if (saved == null) {
			throw new EntityNotFoundException();
		}
		BeanUtils.copyProperties(funcionario, saved, "idFuncionario");

		return funcionarioRepositoy.save(funcionario);
	}

	@Transactional
	public void delete(Long idFuncionario) {
		funcionarioRepositoy.deleteById(idFuncionario);
	}

	public Funcionario findOne(Long idFuncionario) {
		return funcionarioRepositoy.findById(idFuncionario).orElse(null);
	}

	public Page<Funcionario> findAll(Pageable pageable) {
		return funcionarioRepositoy.findAll(pageable);
	}

}