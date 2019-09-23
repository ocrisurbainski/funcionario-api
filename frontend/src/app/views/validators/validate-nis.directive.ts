import { Directive } from '@angular/core';
import { NG_VALIDATORS, Validator, ValidationErrors, AbstractControl } from '@angular/forms';
import { StringUtils } from 'src/app/utils/string-utils';

@Directive({
	selector: '[validateNis][ngModel]',
	providers: [{ provide: NG_VALIDATORS, useExisting: ValidateNisDirective, multi: true }]
})
export class ValidateNisDirective implements Validator {

	private hasErrros : Object = { 'nis' : true };

	validate(control: AbstractControl): ValidationErrors | null {
		let value : number = control.value;
		let valueStr : string = String(value);
		if (valueStr.length != 11) {
			return this.hasErrros;
		}

		let digitoVerificadorCalculado = this.calcularDigitoVerificador(valueStr);
		let digitoVerificadorInformado = Number(valueStr.substring(10, 11));

		if (digitoVerificadorCalculado != digitoVerificadorInformado) {
			return this.hasErrros;
		}

		return null;
	}

	private calcularDigitoVerificador(valueStr : string) : number {
		let pesos : number[] = [3, 2, 9, 8, 7, 6, 5, 4, 3, 2];
		let somaTotal : number = 0;

		let valueStrArray : string[] = valueStr.split('');

		for (let i : number = 0; i < pesos.length; i++) {
			let peso : number = pesos[i];
			let numero : number = Number(valueStrArray[i]);
			somaTotal += (peso * numero);
		}

		let digitoVerificadorCalculado = 11 - (somaTotal % 11);
		if (digitoVerificadorCalculado == 10 || digitoVerificadorCalculado == 11 || digitoVerificadorCalculado == 0) {
			digitoVerificadorCalculado = 0;
		}
		return digitoVerificadorCalculado;
	}

}