package signuplam.model;

/**
 * Entidade representa uma pessoa juridica
 * 
 * @author Reinaldo Sousa
 * 
 */

public class PessoaJuridica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6029648747369362502L;

	/**
	 * Numero de cnpj do cadastro nacional de pessoa juridica
	 */
	private String cnpj;

	/**
	 * Nome fantasia da pessoa juridica
	 */
	private String nomeFantasia;

	/**
	 * Registro formal da empresa junto a Receita Federal
	 */
	private String inscricaoEstadual;

	public PessoaJuridica() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
}
