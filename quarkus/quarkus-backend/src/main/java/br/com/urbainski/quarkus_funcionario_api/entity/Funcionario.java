package br.com.urbainski.quarkus_funcionario_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.urbainski.quarkus_funcionario_api.validation.annotation.Nis;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
@Entity
@Table(name = "FUNCIONARIO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFUNCIONARIO")
	private Long idFuncionario;
	
	@NotEmpty
	@Size(min = 2, max = 30)
	@Column(name = "NOME")
	private String nome;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@Email
	@NotEmpty
	@Size(min = 1, max = 300)
	@Column(name = "EMAIL")
	private String email;
	
	@Nis
	@NotEmpty
	@Size(min = 11, max = 11)
	@Column(name = "NUMERONIS")
	private String numeroNis;

	public Long getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumeroNis() {
		return numeroNis;
	}
	
	public void setNumeroNis(String numeroNis) {
		this.numeroNis = numeroNis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		return true;
	}
	
}