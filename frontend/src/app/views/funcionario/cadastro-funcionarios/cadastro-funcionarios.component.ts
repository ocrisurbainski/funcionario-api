import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario } from 'src/app/entidade/funcionario';
import { FuncionarioService } from 'src/app/service/funcionario.service';
import { Form } from '@angular/forms';

@Component({
	selector: 'app-cadastro-funcionarios',
	templateUrl: './cadastro-funcionarios.component.html',
	styleUrls: ['./cadastro-funcionarios.component.css']
})
export class CadastroFuncionariosComponent implements OnInit {

	public func : Funcionario;

	private isNewFuncionario : boolean;
	
	@ViewChild("formCadFuncionarios", {static: false}) 
	private formCadFuncionarios : any;

	constructor(
		private router : Router,
		private activateRoute : ActivatedRoute,
		private funcionarioService : FuncionarioService) { }

	ngOnInit() {
		this.func = new Funcionario();
		let id : number = this.activateRoute.snapshot.params.id;
		if (id != null) {
			this.isNewFuncionario = false;
			this.funcionarioService.findById(id).subscribe((res) => {
				this.func = res;
			});
		} else {
			this.isNewFuncionario = true;
		}
	}

	ngOnSubmit() {
		if (this.formCadFuncionarios.valid) {
			if (this.isNewFuncionario) {
				this.funcionarioService.save(this.func).subscribe((res) => {
					alert('Funcionário cadastrado com sucesso.');
					this.redireactToList();
				});
			} else {
				this.funcionarioService.update(this.func).subscribe((res) => {
					alert('Funcionário atualizado com sucesso.');
					this.redireactToList();
				});
			}
		}
	}

	private redireactToList() :void {
		this.router.navigate(['/funcionarios/lista']);
	}

}
