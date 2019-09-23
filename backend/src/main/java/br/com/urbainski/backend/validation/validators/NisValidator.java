package br.com.urbainski.backend.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.urbainski.backend.validation.annotation.Nis;

/**
 * 
 * @author Cristian Urbainski
 * @since 02/08/2019
 *
 */
public class NisValidator implements ConstraintValidator<Nis, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int pesos[] = { 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int somaTotal = 0;
		
		for (int i = 0; i < pesos.length; i++) {
			int peso = pesos[i];
			int num = Integer.decode(value.substring(i, i + 1));
			somaTotal += peso * num;
		}
		
		int dvCalculado = 11 - (somaTotal % 11);
		if (dvCalculado == 10 || dvCalculado == 11 || dvCalculado == 0) {
			dvCalculado = 0;
		}
		
		int dvReal = Integer.decode(value.substring(10, 11));
		return dvCalculado == dvReal;
	}
	
}