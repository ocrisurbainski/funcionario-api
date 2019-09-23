import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DefaultIndexComponent } from './views/default-index/default-index.component';
import { CadastroFuncionariosComponent } from './views/funcionario/cadastro-funcionarios/cadastro-funcionarios.component';
import { ListaFuncionariosComponent } from './views/funcionario/lista-funcionarios/lista-funcionarios.component';

const routes: Routes = [
	{ path: '', component: DefaultIndexComponent},
	{ path: 'funcionarios/lista', component: ListaFuncionariosComponent },
	{ path: 'funcionario/cadastro', component: CadastroFuncionariosComponent },
	{ path: 'funcionario/cadastro/:id', component: CadastroFuncionariosComponent }
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
