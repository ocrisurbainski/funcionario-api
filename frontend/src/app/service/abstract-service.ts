import { StringUtils } from '../utils/string-utils';
import { throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

export abstract class AbstractService {

	private defaultUrlApi : string;

	private httpHeaders : HttpHeaders;

	private httpOptions : Object;

	constructor() {
		this.defaultUrlApi = 'http://localhost:8080';
		this.httpHeaders = new HttpHeaders()
			.set('Content-Type', 'application/json');
		this.httpOptions = {
			headers: this.httpHeaders
		}
	}

	protected getDefaultHttpHeaders() : HttpHeaders {
		return this.httpHeaders;
	}

	protected getDefaultHttpOptions() : Object {
		return this.httpOptions;
	}

	protected getCompleteUrl(serviceName : string) : string {
		if (StringUtils.isEmpty(serviceName)) {
			return null;
		}
		let completeUrl : string = this.defaultUrlApi;
		if (serviceName.substring(0, 1) != '/') {
			completeUrl += '/' + serviceName;
		} else {
			completeUrl += serviceName;
		}
		return completeUrl;
	}

	protected handleError(error) {
		let errorMessage = '';
		if (error.error instanceof ErrorEvent) {
			// client-side error
			errorMessage = `Error: ${error.error.message}`;
		} else {
			// server-side error
			errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
		}
		window.alert(errorMessage);
		return throwError(errorMessage);
	}

}
