package signuplam.model;

/**
 * Entidade referencia o endereço de uma pessoa
 * 
 * @author Reinaldo Sousa
 *
 */
public class Endereco extends GenericEntity {

	private static final long serialVersionUID = 8378759123289683164L;
	/**
	 * Bairro
	 */
	private String bairro;

	/**
	 * Numero do endereço
	 */
	private String numero;

	/**
	 * Rua, avenida, travessa, ...
	 */
	private String logradouro;

	/**
	 * Numero do cep
	 */
	private String cep;

	/**
	 * Cidade
	 */
	private String cidade;

	/**
	 * Estado
	 */
	private String estado;

	/**
	 * Pais
	 */
	private String pais;

	/**
	 * Ponto de referencia
	 */
	private String pontoReferencia;

	/**
	 * Complemento do endereço
	 */
	private String complemento;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
