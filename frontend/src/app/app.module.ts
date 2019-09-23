import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {  } from '@angular/forms';

import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { PaginationModule } from 'ngx-bootstrap/pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './views/main/main.component';
import { ToolbarComponent } from './views/main/toolbar/toolbar.component';
import { ContentComponent } from './views/main/content/content.component';
import { ListaFuncionariosComponent } from './views/funcionario/lista-funcionarios/lista-funcionarios.component';
import { CadastroFuncionariosComponent } from './views/funcionario/cadastro-funcionarios/cadastro-funcionarios.component';
import { DefaultIndexComponent } from './views/default-index/default-index.component';
import { PageTitleComponent } from './componente/page-title/page-title.component';

import { FuncionarioService } from './service/funcionario.service';
import { ValidateNisDirective } from './views/validators/validate-nis.directive';

@NgModule({
	declarations: [
		AppComponent,
		MainComponent,
		ToolbarComponent,
		ContentComponent,
		ListaFuncionariosComponent,
		CadastroFuncionariosComponent,
		DefaultIndexComponent,
		PageTitleComponent,
		ValidateNisDirective
	],
	imports: [
		BrowserModule,
		HttpClientModule,
		FormsModule,
		AppRoutingModule,

		TooltipModule.forRoot(),
		PaginationModule.forRoot()
	],
	providers: [
		FuncionarioService
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
