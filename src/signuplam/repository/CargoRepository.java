package signuplam.repository;

import signuplam.model.Cargo;

/**
 * 
 * @author Reinaldo Sousa
 *
 */
public interface CargoRepository {

	public Cargo findByDenominacao(String denominacao);

}
