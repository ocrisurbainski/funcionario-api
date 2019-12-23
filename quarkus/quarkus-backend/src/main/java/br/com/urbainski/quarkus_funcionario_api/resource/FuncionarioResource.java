package br.com.urbainski.quarkus_funcionario_api.resource;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.urbainski.quarkus_funcionario_api.dto.PageDTO;
import br.com.urbainski.quarkus_funcionario_api.dto.PageableDTO;
import br.com.urbainski.quarkus_funcionario_api.entity.Funcionario;
import br.com.urbainski.quarkus_funcionario_api.service.FuncionarioService;

@Path("/funcionario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioResource {
	
	@Inject
	FuncionarioService funcionarioService;
	
	@POST
	public Response save(@Valid Funcionario funcionario) {
		Funcionario funcionarioSaved = funcionarioService.save(funcionario);
		return Response.status(Status.CREATED.getStatusCode()).entity(funcionarioSaved).build();
	}
	
	@PUT
	public Response update(@Valid Funcionario funcionario) {
		Funcionario funcionarioSaved = funcionarioService.update(funcionario);
		return Response.ok(funcionarioSaved).build();
	}
	
	@DELETE
	@Path(("/{id}"))
	public Response delete(@PathParam("id") Long idFuncionario) {
		try {
			funcionarioService.delete(idFuncionario);
			return Response.noContent().build();
		} catch (EntityNotFoundException e) {
			return Response.status(Status.NOT_FOUND.getStatusCode()).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long idFuncionario) {
		Funcionario funcionario = funcionarioService.findOne(idFuncionario);
		if (funcionario == null) {
			return Response.status(Status.NOT_FOUND.getStatusCode()).build();
		}
		return Response.ok(funcionario).build();
	}
	
	@GET
	public Response findAll(@BeanParam PageableDTO pageable) {
		PageDTO<Funcionario> page = funcionarioService.findAll(pageable);
		return Response.ok(page).build();
	}

}