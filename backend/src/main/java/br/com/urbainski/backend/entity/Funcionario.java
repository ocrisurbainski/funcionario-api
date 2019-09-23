package br.com.urbainski.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.urbainski.backend.validation.annotation.Nis;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Cristian Urbainski
 * @since 20/09/2019
 *
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFUNCIONARIO")
	@EqualsAndHashCode.Include
	private Long idFuncionario;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "NOME")
	private String nome;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "EMAIL")
	private String email;
	
	@Nis
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "NUMERONIS")
	private String numeroNis;
	
}