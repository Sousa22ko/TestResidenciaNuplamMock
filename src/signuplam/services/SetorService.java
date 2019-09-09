package signuplam.services;

import signuplam.exception.NegocioException;
import signuplam.model.Setor;
import signuplam.repository.SetorRepository;

public class SetorService {

	SetorRepository repository;

	public Setor findByDenominacao(String denominacao) {
		return repository.findByDenominacao(denominacao);
	}

	public Setor findBySigla(String sigla) {
		return repository.findBySigla(sigla);
	}

	public Setor findByCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}

	public boolean validate(Setor obj) throws NegocioException {
		NegocioException exception = new NegocioException("Violacao de regra de negocio");

		Setor s1 = this.repository.findByDenominacao(obj.getDenominacao());
		Setor s2 = this.repository.findByCodigo(obj.getCodigo());
		Setor s3 = this.repository.findBySigla(obj.getSigla());

		if (s1 != null && obj.getId() == null && s1.getId() != obj.getId())
			exception.addFieldError(new String("Setor ja foi cadastrado no sistema"));

		if (s2 != null && obj.getId() == null && s2.getId() != obj.getId())
			exception.addFieldError(new String("Setor ja foi cadastrado no sistema"));

		if (s3 != null && obj.getId() == null && s3.getId() != obj.getId())
			exception.addFieldError(new String("Setor ja foi cadastrado no sistema"));

		if (obj.getCodigo().length() > 2)
			exception.addFieldError(new String("Setor ja foi cadastrado no sistema"));

		if (Integer.parseInt(obj.getCodigo()) < 0)
			exception.addFieldError(new String("Setor ja foi cadastrado no sistema"));

		if (exception.getErros().size() > 0)
			throw exception;

		return true;
	}
}
