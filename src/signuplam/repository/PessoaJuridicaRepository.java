package signuplam.repository;

import java.util.List;

import signuplam.model.PessoaJuridica;

public interface PessoaJuridicaRepository {

	List<PessoaJuridica> findByCNPJ(String value);

	List<PessoaJuridica> findByNome(String value);

}
