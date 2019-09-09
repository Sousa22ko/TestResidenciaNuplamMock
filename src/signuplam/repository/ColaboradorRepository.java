package signuplam.repository;

import java.util.List;

import signuplam.model.Colaborador;
import signuplam.model.Setor;

public interface ColaboradorRepository {

	Colaborador findByCPF(String value);

	Colaborador findByEmail(String value);

	List<Colaborador> findBySetor(Integer value);

	Setor findSetor(Integer id);
}
