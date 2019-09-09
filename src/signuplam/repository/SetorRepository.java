package signuplam.repository;

import signuplam.model.Setor;

public interface SetorRepository {

	public Setor findByDenominacao(String denominacao);

	public Setor findBySigla(String sigla);

	public Setor findByCodigo(String codigo);
}
