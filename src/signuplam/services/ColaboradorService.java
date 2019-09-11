package signuplam.services;

import java.util.ArrayList;
import java.util.List;

import signuplam.exception.NegocioException;
import signuplam.model.Colaborador;
import signuplam.model.Vinculo;
import signuplam.repository.ColaboradorRepository;

public class ColaboradorService {

	ColaboradorRepository repository;

	public boolean validate(Colaborador obj) throws NegocioException {
		NegocioException exception = new NegocioException("Violacao de regra de negocio");

		Colaborador c = this.repository.findByCPF(obj.getCpf());
		Colaborador c2 = this.repository.findByEmail(obj.getEmail());
		List<Vinculo> vinculos = new ArrayList<Vinculo>();

		for (Vinculo aux : obj.getListVinculo()) {
			if (aux.getStatusVinculo())
				vinculos.add(aux);
		}

		if (c != null && obj.getId() == null)
			exception.addFieldError(new String("CPF ja cadastrado no sistema"));
		if (obj.getId() != null && c != null && !c.getId().equals(obj.getId()))
			exception.addFieldError(new String("CPF ja cadastrado no sistema"));

		if (c2 != null && obj.getId() == null)
			exception.addFieldError(new String("E-mail ja cadastrado no sistema"));
		if (obj.getId() != null && c2 != null && !c2.getId().equals(obj.getId()))
			exception.addFieldError(new String("E-mail ja cadastrado no sistema"));

		if (vinculos.size() > 1)
			exception.addFieldError(new String("O funcionário ja possui um vinculo ativo"));

		if (obj.getStatusCadastro() == null)
			exception.addFieldError(new String("Informe o status do cadastro"));

		if (exception.getErros().size() > 0)
			throw exception;

		return true;
	}

	public Colaborador findByCPF(String cpf) {
		return this.repository.findByCPF(cpf);
	}
	
	public Colaborador findByEmail(String email) {
		return this.repository.findByEmail(email);
	}
}
