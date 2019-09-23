import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Funcionario } from '../entidade/funcionario';
import { AbstractService } from './abstract-service';

@Injectable({
	providedIn: 'root'
})
export class FuncionarioService extends AbstractService {

	constructor(private http: HttpClient) {
		super();
	}

	save(func : Funcionario) : Observable<Funcionario> {
		let url : string = this.getCompleteUrl('/funcionarios');
		return this.http.post<Funcionario>(url, func, this.getDefaultHttpOptions()).pipe(
			retry(1),
			catchError(this.handleError)
		);
	}

	update(func : Funcionario) : Observable<Funcionario> {
		let url : string = this.getCompleteUrl('/funcionarios');
		return this.http.put<Funcionario>(url, func, this.getDefaultHttpOptions()).pipe(
			retry(1),
			catchError(this.handleError)
		);
	}

	findById(idFuncionario : number) : Observable<Funcionario> {
		let url : string = this.getCompleteUrl('/funcionarios/' + idFuncionario);
		return this.http.get<Funcionario>(url).pipe(
			retry(1),
			catchError(this.handleError)
		);
	}

	delete(func : Funcionario) : Observable<any> {
		let url : string = this.getCompleteUrl('/funcionarios/' + func.idFuncionario);
		return this.http.delete(url).pipe(
			retry(1),
			catchError(this.handleError)
		);
	}

	findAll(page : number) : Observable<Funcionario[]> {
		let params = new HttpParams().set('page', String(page));
		let url : string = this.getCompleteUrl('/funcionarios');
		return this.http.get<Funcionario[]>(url, { params }).pipe(
			retry(1),
			catchError(this.handleError)
		);
	}

}