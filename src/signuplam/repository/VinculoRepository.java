package signuplam.repository;

import java.util.List;

import signuplam.model.Vinculo;

public interface VinculoRepository {

	List<Vinculo> findByPessoaJuridica(Integer value);

}
