package signuplam.services;


import signuplam.exception.NegocioException;
import signuplam.model.Cargo;
import signuplam.repository.CargoRepository;

/**
 * 
 * @author Reinaldo Sousa
 *
 */

public class CargoService {
	
	CargoRepository repository;

	public Cargo findByDenominacao(String denominacao) {
		return repository.findByDenominacao(denominacao);
	}

	public boolean validate(Cargo obj) throws NegocioException {
		NegocioException exception = new NegocioException("Violacao de regra de negocio");

		Cargo c = this.repository.findByDenominacao(obj.getDenominacao());

		if (c != null && obj.getId() == null && c.getId() != obj.getId())
			exception.addFieldError(new String("Cargo ja foi cadastrado no sistema"));

		if (exception.getErros().size() > 0)
			throw exception;

		return true;
	}
}
