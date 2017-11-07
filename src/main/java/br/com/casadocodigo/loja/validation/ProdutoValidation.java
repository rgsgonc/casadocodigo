package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator {
	/*O método supports também precisa ser implementado. A implementação desse método indica a qual classe a 
	 * validação dará suporte. Sabemos que será a classe Produto. Vamos então fazer essa implementação da 
	 * seguinte forma:*/
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	//o método Validate é onde realmente acontecerá a validação.
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

		Produto produto = (Produto) target;
		if (produto.getPaginas() <= 0) {
			errors.rejectValue("paginas", "field.required");
		}
	}

}
