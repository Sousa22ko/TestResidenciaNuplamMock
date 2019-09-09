package signuplam.exception;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável por encapsular violações de regras de negócio e
 * retorná-las como uma exceção. Faz uso de uma lista de FieldErrors, de modo a
 * associar os erros ao campo onde o erro aconteceu.
 * 
 * @author Talison Costa
 *
 */
public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Lista de erros por campo
	 */
	private List<String> erros = new ArrayList<String>();

	public NegocioException(String msg) {
		super(msg);
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public void addFieldError(String error) {
		this.erros.add(error);
	}
	
	public List<String> getDefaultMessages() {
		List<String> defaultMessages = new ArrayList<String>();
		for (String err : erros) {
			defaultMessages.add(getDefaultMessage(err.toString()));
		}
		return defaultMessages;
	}
	
	public static String getDefaultMessage(String fieldErrorToString) {
		String defaultMessage = fieldErrorToString.substring(fieldErrorToString.indexOf("default message [") + 17);
		defaultMessage = defaultMessage.substring(0, defaultMessage.indexOf("]"));
		return defaultMessage;
	}

}
