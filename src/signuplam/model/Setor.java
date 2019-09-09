package signuplam.model;

/**
 * Entidade que define o setor
 * 
 * @author Reinaldo Sousa
 */

public class Setor extends GenericEntity {

	private static final long serialVersionUID = 8378759123289683164L;

	/**
	 * Numero do codigo do setor.
	 */
	private String codigo;

	/**
	 * Nome do setor
	 */
	private String denominacao;

	/**
	 * Sigla do setor
	 */
	private String sigla;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSiglaDenominacao() {
		return sigla + " - " + denominacao;
	}

}
