package br.com.urbainski.quarkus_funcionario_api.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class AbstractCommonService {

	@Inject
	EntityManager entityManager;
	
}