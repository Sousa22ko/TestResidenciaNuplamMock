package signuplam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Entidade que define pessoa fisica, pode ser bolsista ou funcionário da nuplam
 * 
 * @author Reinaldo Sousa
 * 
 */
public class Colaborador extends PessoaFisica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3562000564576155650L;

	/**
	 * Status do cadastro da Pessoa Física. Exs.: Cadastro pendente = False -
	 * Cadastro finalizado = True.
	 */
	private Boolean statusCadastro;

	/**
	 * Referencia ao vinculo do colaborador
	 */
	private List<Vinculo> listVinculo;

	/**
	 * Referencia a ctps do funcionario
	 */
	private Ctps ctps;

	/**
	 * Referencia a lista de dependentes do funcionario
	 */


	public Colaborador() {
		listVinculo = new ArrayList<Vinculo>();
	}

	public Ctps getCtps() {
		return ctps;
	}

	public void setCtps(Ctps ctps) {
		this.ctps = ctps;
	}

	public List<Vinculo> getListVinculo() {
		return listVinculo;
	}

	public void setListVinculo(List<Vinculo> listVinculo) {
		this.listVinculo = listVinculo;
	}

	public Boolean getStatusCadastro() {
		return statusCadastro;
	}

	public void setStatusCadastro(Boolean statusCadastro) {
		this.statusCadastro = statusCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ctps == null) ? 0 : ctps.hashCode());
		result = prime * result + ((listVinculo == null) ? 0 : listVinculo.hashCode());
		result = prime * result + ((statusCadastro == null) ? 0 : statusCadastro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (ctps == null) {
			if (other.ctps != null)
				return false;
		} else if (!ctps.equals(other.ctps))
			return false;
		if (listVinculo == null) {
			if (other.listVinculo != null)
				return false;
		} else if (!listVinculo.equals(other.listVinculo))
			return false;
		if (statusCadastro == null) {
			if (other.statusCadastro != null)
				return false;
		} else if (!statusCadastro.equals(other.statusCadastro))
			return false;
		return true;
	}

}
