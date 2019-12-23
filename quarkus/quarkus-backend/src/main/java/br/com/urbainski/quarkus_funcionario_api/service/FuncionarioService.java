package br.com.urbainski.quarkus_funcionario_api.service;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import br.com.urbainski.quarkus_funcionario_api.dto.PageDTO;
import br.com.urbainski.quarkus_funcionario_api.dto.PageableDTO;
import br.com.urbainski.quarkus_funcionario_api.entity.Funcionario;

@RequestScoped
public class FuncionarioService extends AbstractCommonService {

	@Transactional
	public Funcionario save(Funcionario funcionario) {
		return entityManager.merge(funcionario);
	}
	
	@Transactional
	public Funcionario update(Funcionario funcionario) {
		return entityManager.merge(funcionario);
	}

	@Transactional
	public void delete(Long idFuncionario) {
		Funcionario funcionario = entityManager.getReference(Funcionario.class, idFuncionario);
		entityManager.remove(funcionario);
	}

	public Funcionario findOne(Long idFuncionario) {
		return entityManager.find(Funcionario.class, idFuncionario);
	}

	public PageDTO<Funcionario> findAll(PageableDTO pageable) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
		cq.from(Funcionario.class);
		
		int offset = (pageable.getPageNumber() - 1) * pageable.getPageSize();
		
		TypedQuery<Funcionario> typedQuery = entityManager.createQuery(cq);
		typedQuery.setFirstResult(offset);
		typedQuery.setMaxResults(pageable.getPageSize());
		
		PageDTO<Funcionario> page = new PageDTO<Funcionario>();
		page.setPageNumber(pageable.getPageNumber());
		page.setPageSize(pageable.getPageSize());
		page.setData(typedQuery.getResultList());
		return page;
	}
	
}