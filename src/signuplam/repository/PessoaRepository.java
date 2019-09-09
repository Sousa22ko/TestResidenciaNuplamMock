package signuplam.repository;

import java.util.List;

import signuplam.model.Pessoa;

/**
 * 
 * @author Reinaldo Sousa
 *
 */
public interface PessoaRepository {

	public Pessoa findByNome(String nome);

	public List<Pessoa> findByNullUser();

}
